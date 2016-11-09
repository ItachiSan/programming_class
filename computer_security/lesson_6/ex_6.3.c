#include <stdio.h>
#include <string.h>

int main (int argc, char ** argv) {
	char buffer[2];

	if (argc < 2) {
		printf("An argument please!\n");
		return 1;
	}

	printf("Exploiting via returning into libc functions\n");
	strcpy(buffer, argv[1]);
	printf("You tiped: %s\n", buffer);
	return 0;
}
