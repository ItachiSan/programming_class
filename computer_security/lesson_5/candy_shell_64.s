# Shell candy from the professor
.text

.globl _start

_start:
	movq $0, %rdx # Third argument: pointer to NULL
	movq $0, %rsi # Second argument: pointer to message
	movq $0, %rdi # First argument: pointer to filename
	movq $59, %rax # execve syscall number
	syscall
	# After the shell, exit
	movq $0, %rbx
	movq $1, %rax
	syscall

.data
sh:	.ascii "/bin/sh"
	.byte 0
