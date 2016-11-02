#include <stdio.h>
#include <stdlib.h>

int main(int argc, char * argv[]) {
	char * addr;
	if (argc < 2)
		printf("Usage: %s <env variable name>\n", argv[0]);
	else {
		addr = getenv(argv[1]);
		if (addr == NULL)
			printf("The variable %s doesn't exist\n", argv[1]);
		else
			printf("The variable %s is located at %p\n", argv[1], addr);
	}
}