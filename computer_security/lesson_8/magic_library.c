/*
	Creating function replacements to use strace.
*/

int ptrace(int a, int b, int c, int d) {
	return 0;
}