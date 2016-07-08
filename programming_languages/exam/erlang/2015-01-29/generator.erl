-module(generator).
-export([init/4]).

init(N, M, Period, Next) ->
	Mod = trunc(math:pow(M,Period-1)),
	Max = trunc(math:pow(N,M)),
	send_sequence(N, M, Mod, Next, 0, Max).

send_sequence(_, _, _, _, Times, Max) when Times == Max -> true;
send_sequence(N, M, Mod, Next, Times, Max) ->
	receive
		{seq, Seq, perm, P} when Seq == Times ->
			Value = ((Seq div Mod) rem M) + 1,
			%io:format("Sending to next: ~p~n", [[Value|P]]),
			Next ! {seq, Seq, perm, [Value|P]},
			send_sequence(N, M, Mod, Next, Times+1, Max);
		Other ->
			io:format("generator: received wrong message ~p~n", [Other])
	end.
