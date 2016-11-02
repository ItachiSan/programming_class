int main() {
	int cookie;
	char buf[80];

	printf("buf: %08x cookie: %08x\n", &buf, &cookie);
	gets(buf);
	if(cookie == 0x00a0d00)
		printf("You lose!\n");
}
