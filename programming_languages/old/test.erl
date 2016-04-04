-module(test).
-export([hello/0, hello_slaves/1]). % , hello_slaves/1

hello() -> io:fwrite("Hello world!\n").

hello_slaves(N) when (N =< 0) -> ok;
hello_slaves(N) ->
	spawn(fun() -> io:format("Hello world by slave ~p~n", [N]) end),
	hello_slaves(N - 1).
