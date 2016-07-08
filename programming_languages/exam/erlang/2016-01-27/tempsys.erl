-module(tempsys).
-export([startsys/0]).

%% Conversions:
% Fahrenheit [°F] = [°C] × 9⁄5 + 32
% Kelvin [K] = [°C] + 273.15
% Rankine [°R] = ([°C] + 273.15) × 9⁄5
% Delisle [°De] = (100 − [°C]) × 3⁄2
% Newton [°N] = [°C] × 33⁄100
% Réaumur [°Ré] = [°C] × 4⁄5
% Rømer [°Rø] = [°C] × 21⁄40 + 7.5

% Functions for conversion to Celsius.
fromC(T) -> T.
fromF(T) -> (T - 32) * (9/5).
fromK(T) -> (T - 273.15).
fromR(T) -> ((T * (5/9)) - 273.15).
fromD(T) -> (100 - (T * 2/3)).
fromN(T) -> T * (100/33).
fromRe(T) -> T * (5/4).
fromRo(T) -> ((T - 7.5) * (40/21)).

% Function for conversion from Celsius to other.
toC(T) -> T.
toF(T) -> (T * (9/5)) + 32.
toK(T) -> (T + 273.15).
toR(T) -> (T + 273.15) * (9/5).
toD(T) -> (100 - T) * (3/2).
toN(T) -> T * (33/100).
toRe(T) -> T * (4/5).
toRo(T) -> ((T * (21/40)) + 7.5).

% Get the ID of the correct node to send info
node_id(Action, S) -> list_to_atom(lists:concat([Action, S])).

% Loop of a 'from' node.
fromLoop(F) ->
	receive
		{client, C, from, T1, to, T2, value, X} ->
			ID = node_id('to',T2),
			%io:format("sending to ~p~n", [ID]),
			ID ! {client, C, from, self(), convert, F(X)},
			fromLoop(F);
		{client, C, result, X} ->
			C ! {result, X},
			fromLoop(F);
		Other ->
			io:format("~p node: received wrong message ~p~n", [F, Other]),
			fromLoop(F)
	end.

% Loop of a 'to' node.
toLoop(F) ->
	receive
		{client, C, from, FromNode, convert, X} ->
			FromNode ! {client, C, result, F(X)},
			toLoop(F);
		Other ->
			io:format("~p node: received wrong message ~p~n", [F, Other]),
			toLoop(F)
	end.

startsys() ->
	FromNodes = [
		{'C', fun fromC/1},
		{'F', fun fromF/1},
		{'K', fun fromK/1},
		{'R', fun fromR/1},
		{'D', fun fromD/1},
		{'N', fun fromN/1},
		{'Re', fun fromRe/1},
		{'Ro', fun fromRo/1}
	],
	ToNodes = [
		{'C', fun toC/1},
		{'F', fun toF/1},
		{'K', fun toK/1},
		{'R', fun toR/1},
		{'D', fun toD/1},
		{'N', fun toN/1},
		{'Re', fun toRe/1},
		{'Ro', fun toRo/1}
	],
	lists:foreach(
		fun({X,F}) ->
			register(
				node_id('from', X),
				spawn(fun() ->  fromLoop(F) end)
			)
			end,
		FromNodes
	),
	lists:foreach(
		fun({X,F}) ->
			register(
				node_id('to', X),
				spawn(fun() -> toLoop(F) end)
			)
			end,
		ToNodes
	).
