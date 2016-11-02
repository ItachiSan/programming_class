# Shell candy from the professor
.text

.globl _start

# Make it position independent, step 1...
_start:
	jmp reset_label
# The real code...
real_code:
	movq $0, %rdx # Third argument: pointer to NULL
	movq $0, %rsi # Second argument: pointer to message
	movq $sh, %rdi # First argument: pointer to filename
	movq $59, %rax # execve syscall number
	syscall
	# After the shell, exit
	movq $0, %rbx
	movq $1, %rax
	syscall
# Make it position independent, step 2!
reset_label:
	call real_code

.data
sh:	.ascii "/bin/sh"
	.byte 0
