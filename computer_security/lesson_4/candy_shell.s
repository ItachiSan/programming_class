.text
.global _start
_start:
	jmp lab1
goback:
	# execve syscall
	xorl	%eax, %eax
	movb	$0xb, %al
	# Push the shell
	popl	%ebx
	# Create a fake struct
	xorl	%ecx, %ecx
	pushl	%ecx
	pushl	%ebx
	movl	%esp, %ecx
	# NULL as edx
	xorl	%edx, %edx
	int		$0x80

lab1:
	call goback
msg: .ascii "/bin/sh"
