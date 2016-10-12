#include <stdio.h>

int foo(int i);
int bar(int j);

int main(int argc, char **argv){
	int x = foo(10);
	printf("The value of x = %d\n", x);
	return 0;
}

int foo(int i){
	int ii = i + i;
	int iii = bar(ii);
	int iiii = iii;
	return iiii;
}

int bar(int j) {
	int jj = j + j;
	return jj;
}
