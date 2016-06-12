-module(exercise_1).
-export([is_palindrome/1, is_an_anagram/2, factors/1, is_proper/1, primes/1, divisors/2]).

% The available function for checking a palindrome string.
is_palindrome(S) -> check_palindrome(filter(S)).

% Check it a string is palindrome.
check_palindrome([]) -> true;
check_palindrome([_]) -> true;
check_palindrome([H|L]) -> (H == lists:last(L)) and check_palindrome(lists:droplast(L)).

% Keep only letters, in lowercase.
filter([]) -> [];
filter([H|L]) when H >= $a, H =< $z -> [H|filter(L)];
filter([H|L]) when H >= $A, H =< $Z -> [string:to_lower(H)|filter(L)];
filter([_|L]) -> filter(L).

% Check if the string as first input is an anagram of a string in the string
% list passed as second parameter.
is_an_anagram([], _) -> false;
is_an_anagram(_, []) -> false;
is_an_anagram(S, [H|L]) ->
	X = filter(S),
	Y = filter(H),
	((length(X) == length(Y)) and (X--Y == "")) or is_an_anagram(S,L).

% Calculate prime factors of an integer.
factors(N) when N > 1 ->
	D = hd(primes(N)),
	[D|factors(N div D)];
factors(_) -> [].

% Find prime factors below a certain top value. Excluding only "1".
primes(N) when N > 1 ->
	[X || X <- divisors(N,2), length(divisors(X,2)) == 1];
primes(_) -> [].

% Verify if a number is a proper number.
is_proper(N) when N > 1 -> lists:sum(lists:droplast(divisors(N,1))) == N;
is_proper(_) -> false.

% Find all divisors of a certain number.
divisors(N,S) when N > 1 ->
	[X || X <- lists:seq(S,N), (N rem X == 0)];
divisors(_,_) -> [].
