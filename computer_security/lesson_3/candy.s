.text
.global _start
_start:
	movl $len, %edx
	movl $string, %ecx
	movl $1, %ebx
	movl $4, %eax
	int $0x80

data:
string: .ascii "You win!"
	len = . - string
