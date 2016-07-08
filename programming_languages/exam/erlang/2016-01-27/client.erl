-module(client).
-export([convert/5]).

convert(from, T1, to, T2, X) ->
	ID = list_to_atom(lists:concat([from, T1])),
	ID ! {client, self(), from, T1, to, T2, value, X},
	receive
		{result, R} ->
			io:format("~p°~p are equivalent to ~p°~p ~n", [X, T1, R, T2]);
		Other ->
			io:format("client: received unknown message ~p~n", [Other])
	end.
