-module(exercise_2).
-export([parse/1, tokenize/1, test_op/1, test_token/1]). % eval/1]).

% Convert a mathematical function to an "exp".
parse(exp) -> tokenize(exp).

tokenize([]) -> [];
tokenize([$(|L]) -> [start|tokenize(L)];
tokenize([$)|L]) -> [finish|tokenize(L)];
tokenize([$+|L]) -> [plus|tokenize(L)];
tokenize([$-|L]) -> [minus|tokenize(L)];
tokenize([$*|L]) -> [multiply|tokenize(L)];
tokenize([$/|L]) -> [divide|tokenize(L)];
tokenize([$~|L]) -> [negate|tokenize(L)];
tokenize([H|L]) when H >= $0, H =< $9 ->
	{X,T} = string:to_integer([H|L]),
	[{num, X}|tokenize(T)].

test_op([A,OP,B|Rest]) -> {OP,A,B};
test_op(_) -> [].

test_token([start|Expr]) ->
	{Ast, [finish | Txt1]} = test_token(Expr),
	{Ast, Txt1};
test_token([A,OP,B|Rest]) -> {{OP,A,B},Rest};
test_token(_) -> {}.

get_sub_expression([]) -> [];
get_sub_expression([H|L]) when lists:member(finish,L) == true ->
	[H|get_sub_expression(L)];
get_sub_expression(_) -> [].
