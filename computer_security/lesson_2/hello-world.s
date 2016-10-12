.text
.global _start

_start:
	# Print 1st string
	movl len1, %edx # Push string lenght as 3rd argument
	movl msg1, %ecx # Push string pointer as 2nd argument
	movl $1, %ebx 	# Push channel (1 = stdout) as 1st argument
	movl $4, %eax 	# Call 'write' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Exit successfully
	movl $0, %ebx	# Successful exit
	movl $1, %eax	# Syscall code for exit
	int $0x80

.data
msg1: .ascii "Hello world!\n"
	len1 = . - msg1 # From here to the start of the string... it is the string length!
