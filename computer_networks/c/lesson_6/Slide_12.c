// Resolve hostnames with getbyhostname
#include <netdb.h>
// Definitions of various network related data structures
#include <arpa/inet.h>
// Useful standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// Give an usage message
void usage(char * programname) {
	printf("Usage: %s MODE HOSTNAME\n", programname);
	printf("MODE can be equal to:\n");
	printf("\ts -> resolve a symbolic hostname (using DNS)\n");
	printf("\td -> resolve a dotted hostname (a normal IP address)\n");
	printf("\t     (can be used to check IP addresses)\n");
}

// Resolve the hostname and print it on screen.
int resolve_name(char * mode, char * name, char * programname) {
	if (strcmp(mode, "s") == 0) {
		// Symbolic hostname, should do lookup
		// Let's handle errors
		int h_errno;
		// Try to resolve the hostname
		struct hostent * host = gethostbyname(name);
		// Let's check if we had some errors
		if (host == NULL) {
			fprintf(stderr, "Error in gethostbyname: %s\n", hstrerror(h_errno));
			return EXIT_FAILURE;
		} else {
			// Print the version of IP used
			char * type;
			switch (host->h_addrtype) {
				case AF_INET6:
					type = "IPv6";
					break;
				case AF_INET:
					type = "IPv4";
					break;
				default:
					type = "Unknown";
			}
			// Print all the data
			printf("The data we got is:\n");
			printf("\thostname: %s\n", host->h_name);
			printf("\tIP version: %s\n", type);
			printf("\taddress: %s\n", host->h_addr_list[0]);
			printf("\taddress length: %d\n", host->h_length);
			printf("\taddress (int representation): %d\n",
				inet_addr(host->h_addr_list[0])
			);
			return EXIT_SUCCESS;
		}
	} else if (strcmp(mode, "d") == 0) {
		in_addr_t address = inet_addr(name);
		if (address == -1) {
			fprintf(stderr, "Error in inet_addr(%s)\n", name);
			return EXIT_FAILURE;
		} else {
			printf("Address %s in in_addr representation: %u\n", name, address);
			return EXIT_SUCCESS;
		}
	} else {
		fprintf(stderr, "Wrong mode passed: %s\n", mode);
		usage(programname);
		return EXIT_FAILURE;
	}
}

// The actual program
int main(int argc, char ** argv) {
	/*
	printf("argc: %d\n", argc);
	int i;
	for (i = 0; i < argc; i++)
		printf("argv[%d]: %s\n", i, argv[i]);
	return EXIT_SUCCESS;
	*/

	switch (argc) {
		case 3:
			return resolve_name(argv[1], argv[2], argv[0]);
		default:
			// The executable name should be always defined... right?
			usage(argv[0]);
			return EXIT_SUCCESS;
	}
}
