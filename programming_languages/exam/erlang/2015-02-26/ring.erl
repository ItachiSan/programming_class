-module(ring).
-export([start/2, send_message/1, send_message/2, stop/0]).

% Handle the messages between the nodes.
node_loop(Function, Next, IsLast) ->
	receive
		{in, Client, Input, Times} ->
			self() ! {wip, Client, Input, Times},
			node_loop(Function, Next, IsLast);
		{wip, Client, Input, 1} when IsLast ->
			Client ! {out, Function(Input)},
			node_loop(Function, Next, IsLast);
		{wip, Client, Input, Times} when IsLast ->
			head ! {wip, Client, Function(Input), Times - 1},
			node_loop(Function, Next, IsLast);
		{wip, Client, Input, Times} ->
			Next ! {wip, Client, Function(Input), Times},
			node_loop(Function, Next, IsLast);
		die ->
			Next ! die,
			io:format("node_loop: slave ~p closed successfully~n", [self()]);
		Other ->
			io:format("node_loop: received unexpected message ~p~n", [Other]),
			node_loop(Function, Next, IsLast)
	end.

% Create the ring of nodes.
% The last one should report the result to the head, after the needed loops.
build_ring(Head, [Function]) ->
	node_loop(Function, Head, true);
build_ring(Head, [Function|OtherFunctions]) ->
	Next = spawn_link(fun () -> build_ring(Head, OtherFunctions) end),
	node_loop(Function, Next, false).

% Just call the real ring builder.
ring(Functions) -> spawn(fun () -> build_ring(self(), Functions) end).

% Start the processes ring.
start(N, Functions) when N /= length(Functions) ->
	io:format("Sizes mismatch!~n");
start(_, Functions) -> register(head, ring(Functions)).

% Send needed messages.
send_message(Input) -> send_message(Input, 1).
send_message(Input, Times) ->
	head ! {in, self(), Input, Times},
	receive
		{out, Result} -> Result;
		Other -> io:format("send_message: got unexpected message ~p~n", [Other])
	end.

% Stop the function resolver ring.
stop() -> head ! die.
