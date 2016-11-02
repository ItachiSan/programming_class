.text
.global _start
_start:
	jmp lab1
goback:
	# Clear stuff
	xorl	%eax, %eax
	xorl	%ebx, %ebx
	xorl	%edx, %edx
	movb	$8, %dl		# Length of string
	popl	%ecx		# Pointer to the string
	movb	$1, %bl		# sysout
	movb	$4, %al		# write syscall
	int		$0x80
	xorl	%ebx, %ebx
	movb	$1, %al
	int		$0x80
lab1:
	call goback
msg: .ascii "You win!"
