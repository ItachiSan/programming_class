-module(combinator).
-export([start/2]).
-import(generator, [init/4]).

start(N,M) ->
	Master=self(),
	Max = trunc(math:pow(N,M)),
	Head=spawn_link(fun() -> create_slaves(N, M, Master) end),
	Head ! {seq, 0, perm, []},
	get_reply(N, M, Max, Head).

create_slaves(N, M, N, Master) ->
	init(N, M, N, Master);
create_slaves(N, M, X, Master) ->
	Next=spawn_link(fun() -> create_slaves(N, M, X+1, Master) end),
	init(N, M, X, Next).
create_slaves(N, M, Master) -> create_slaves(N, M, 1, Master).

get_reply(N, M, Max, Head) ->
	receive
		{seq, Seq, perm, P} when Seq == Max-1 ->
			print_permutation(P);
		{seq, Seq, perm, P} ->
			%io:format("Master receive: ~p -> ~p~n", [Seq,P]),
			print_permutation(P),
			Head ! {seq, Seq+1, perm, []},
			get_reply(N, M, Max, Head);
		Other ->
			io:format("master: received wrong message ~p~n", [Other]),
			get_reply(N, M, Max, Head)
	end.

print_permutation([T]) ->
	io:format("~p~n", [T]);
print_permutation([H|T]) ->
	io:format("~p, ", [H]),
	print_permutation(T).

