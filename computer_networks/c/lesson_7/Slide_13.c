// Resolve hostnames with getbyhostname
#include <netdb.h>
// Definitions of various network related data structures
#include <arpa/inet.h>
// For 'close'
#include <unistd.h>
// Useful standard libraries
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

// Maximum size of accepted message
#define BUFFER 512

// Give an usage message
void usage(char * programname) {
	printf("Usage: %s MODE HOST PORT\n", programname);
	printf("MODE represent the mode used by the program for working:\n");
	printf("\tc: client mode\n");
	printf("\ts: server mode\n");
	printf("Clients should also pass the following parameters:\n");
	printf("HOST should represent a valid IP to connect to\n");
	printf("PORT should be the port used by the server\n");
}

// Start an UDP socket
int setup(int * socket_descriptor,
	struct sockaddr_in * socket_address) {
	// Fetch needed data related to the protocol
	char * proto_string = "udp";
	struct protoent * proto = getprotobyname(proto_string);
	if (proto == NULL) {
		fprintf(stderr, "setup: error in getprotobyname %s\n", proto_string);
		return EXIT_FAILURE;
	}
	// Create an UDP socket
	int errno = 0;
	*socket_descriptor = socket(PF_INET, SOCK_DGRAM, proto->p_proto);
	if (*socket_descriptor == -1) {
		fprintf(stderr, "setup: error in socket creation (%s)\n", strerror(errno));
		return EXIT_FAILURE;
	}
	// Create the needed socket address
	socket_address->sin_family = AF_INET;
	socket_address->sin_addr.s_addr = INADDR_ANY; // Accept any IP
	socket_address->sin_port = htons(0); // Assume any port is fine, for starting
	// Bind the socket
	int result = bind(
		*socket_descriptor,
		(struct sockaddr *) socket_address,
		sizeof(*socket_address)
	);
	if (result != 0) {
		fprintf(stderr, "setup: error in socket binding (%s)\n", strerror(errno));
		return EXIT_FAILURE;
	}
	return EXIT_SUCCESS;
}

// The main loop for the server
int server_mode() {
	// Set up the socket
	int socket_descriptor;	
	struct sockaddr_in socket_address;
	int creation = setup(&socket_descriptor, &socket_address);
	// Exit if socket setup goes wrong
	if (creation != EXIT_SUCCESS) return creation;
	// The message buffer
	char message[BUFFER];
	// The socket data representing the client
	struct sockaddr_in client_socket_address;
	socklen_t client_socket_address_length = sizeof(client_socket_address);
	// A boolean that represents we are running
	bool running = true;
	// An integer used for various checks.
	int result;
	// An integer setted up from possible errors.
	int errno = 0;

	// Fetch local data to give to the clients
	struct sockaddr_in local_addr;
	socklen_t local_addr_length = sizeof(local_addr);
	result = getsockname(socket_descriptor, (struct sockaddr *) &local_addr, &local_addr_length);
	if (result < 0) {
		fprintf(stderr, "server: error getting the local address (%s)\n", strerror(errno));
		return EXIT_FAILURE;
	} else {
		printf("server: running with address %s port %u\n",
			inet_ntoa(local_addr.sin_addr),
			ntohs(local_addr.sin_port)
		);
	}

	while (running) {
		// Clean up the message buffer
		memset(message, 0, BUFFER);
		// Receive the message
		result = recvfrom(socket_descriptor, message, BUFFER, 0,
			(struct sockaddr *) &client_socket_address, &client_socket_address_length);
		if (result > 0) {
			printf("server: received string %s from client %s:%u (size %d)\n",
			message, inet_ntoa(client_socket_address.sin_addr),
			ntohs(client_socket_address.sin_port),
			result);
			// Close if we said bye properely
			size_t message_length = result;
			if (strncmp(message, "bye", message_length) == 0){
				running = false;
				memcpy(message, "bye", 4 * sizeof(char));
			} else {
				// Reverse the string
				int i, k;
				char c;
				for (i = 0, k = message_length - 1; i < message_length/2; i++, k--) {
					c = message[k];
					message[k] = message[i];
					message[i] = c;
				}
			}
			// Send the reversed string
			printf("server: reply message: %s\n", message);
			result = sendto(socket_descriptor, message, message_length, 0,
				(struct sockaddr *) &client_socket_address,
				client_socket_address_length
			);
			printf("server: reply message after sendto: %s\n", message);
			// Report if we sent back the message properely
			if (result > 0)
				printf("server: sent string %s to client %s:%u\n",
					message, inet_ntoa(client_socket_address.sin_addr),
					ntohs(client_socket_address.sin_port)
				);
			else
				fprintf(stderr, "server: error in sendto (%s)", strerror(errno));
		} else {
			fprintf(stderr, "server: error receiveing message (%s)\n", strerror(errno));
		}
	}
	// Closing the server
	printf("server: shutdown\n");
	result = close(socket_descriptor);
	if (result < 0) {
		fprintf(stderr, "server: error closing socket\n");
		return EXIT_FAILURE;
	} else
		return EXIT_SUCCESS;
}

// The main loop for the server
int client_mode(char * host, char * port) {
	// The message buffer
	char message[BUFFER];
	// A boolean that represents we are running
	bool running = true;
	// An integer used for various checks.
	int result;
	// An integer setted up from possible errors.
	int errno = 0;

	// Set up the socket
	int socket_descriptor;	
	struct sockaddr_in socket_address;
	int creation = setup(&socket_descriptor, &socket_address);
	// Exit if socket setup goes wrong
	if (creation != EXIT_SUCCESS) return creation;

	// The socket data representing the server
	struct sockaddr_in server_socket_address;
	socklen_t server_socket_address_length = sizeof(server_socket_address);
	// Set up info for the server socket and fetch the data of the server
	server_socket_address.sin_family = AF_INET;
	struct hostent * hostinfo = gethostbyname(host);
	server_socket_address.sin_addr = *((struct in_addr *) hostinfo->h_addr);
	server_socket_address.sin_port = htons(atoi(port));

	while (running) {
		// Clean up the message buffer
		memset(message, 0, BUFFER);
		// Read the message
		printf("client: type the message to send: ");
		scanf("%s", message);
		size_t message_length = strlen(message);
		// Receive the message
		result = sendto(socket_descriptor, message, message_length, 0,
			(struct sockaddr *) &server_socket_address, server_socket_address_length);
		if (result > 0) {
			printf("client: sent string %s from client %s:%u\n",
				message, inet_ntoa(server_socket_address.sin_addr),
				ntohs(server_socket_address.sin_port)
			);
			// Receive the reversed string
			result = recvfrom(socket_descriptor, message, BUFFER, 0,
				(struct sockaddr *) &server_socket_address,
				&server_socket_address_length
			);
			// Report if we sent back the message properely
			if (result > 0) {
				printf("client: received string %s to client %s:%u\n",
					message, inet_ntoa(server_socket_address.sin_addr),
					ntohs(server_socket_address.sin_port)
				);
				// Close if we said bye properely
				if (strncmp(message, "bye", 3) == 0)
					running = false;
			} else
				fprintf(stderr, "server: error in sendto (%s)", strerror(errno));
		} else {
			fprintf(stderr, "server: error receiveing message (%s)\n", strerror(errno));
		}
	}
	// Closing the server
	printf("client: shutdown\n");
	result = close(socket_descriptor);
	if (result < 0) {
		fprintf(stderr, "client: error closing socket (%s)\n", strerror(errno));
		return EXIT_FAILURE;
	} else
		return EXIT_SUCCESS;
}

// The actual program
int main(int argc, char ** argv) {
	switch (argc) {
		case 2:
			if (strncmp(argv[1], "s", 1) == 0)
				return server_mode();
			else {
				fprintf(stderr, "Wrong mode: %s", argv[1]);
				usage(argv[0]);
				return EXIT_FAILURE;
			}
		case 4:
			if (strncmp(argv[1], "s", 1) == 0)
				return server_mode();
			else if (strncmp(argv[1], "c", 1) == 0)
				return client_mode(argv[2], argv[3]);
			else {
				fprintf(stderr, "Wrong mode: %s", argv[1]);
				usage(argv[0]);
				return EXIT_FAILURE;
			}
		default:
			// The executable name should be always defined... right?
			usage(argv[0]);
			return EXIT_SUCCESS;
	}
}
