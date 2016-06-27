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
	printf("Usage: %s SERVICE PROTOCOL\n", programname);
	printf("SERVICE should be equal to a common service name (e.g. smtp, echo, http...)\n");
	printf("PROTOCOL should be equal to a protocol service ('tcp' or 'udp')");
}

// Check if a service is existing or not
int check_service(char * service_name, char * protocol) {
	// Check for a proper service
	struct servent * service = getservbyname(service_name, protocol);
	if (service == NULL) {
		fprintf(stderr, "No valid service found for combination %s %s\n",
			service_name, protocol
		);
		return EXIT_FAILURE;
	} else {
		printf("Service found:\n");
		printf("\tservice name: %s\n", service->s_name);
		printf("\tservice protocol: %s\n", service->s_proto);
		printf("\tservice port: %u\n", ntohs(service->s_port));
		return EXIT_SUCCESS;
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
			return check_service(argv[1], argv[2]);
		default:
			// The executable name should be always defined... right?
			usage(argv[0]);
			return EXIT_SUCCESS;
	}
}
