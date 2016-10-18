#include <stdio.h>

int x = 0;

int function(int x) {
	x = x + 13;
}

void main() {
	x = function(x);
	x = 10;
	printf("Value of x: %d!\n", x);
}
