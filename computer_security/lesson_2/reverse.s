.text
.global _start

# Reverse string function.
reverse_string:
	# Save registers
	push %eax
	push %ebx
	push %ecx
	push %edx
	# Exclude the '\n'
	dec %eax
	dec %eax
	# Reset internal counter
	movl $0, %ecx

reverse_push:
	# Check if we finished...
	cmp %ecx, %eax
	jl reverse_pop
	# Else push on stack
	dec %esp
	movb (%ebx,%ecx,1), %dl
	movb %dl, (%esp)
	inc %ecx
	jmp reverse_push

reverse_pop:
	# Check if we finished...
	cmp $0, %ecx
	jle reverse_ret
	# Save status
	push %eax
	push %ebx
	push %ecx
	push %edx
	# Print the byte
	movl $1, %edx
	movl %esp, %ecx
	movl $1, %ebx
	movl $4, %eax
	int $0x80
	# Remember we popped stuff
	inc %esp
	# Restore status
	pop %edx
	pop %ecx
	pop %ebx
	pop %eax
	# Fix counters
	dec %ecx
	jmp reverse_pop

reverse_ret:
	pop %edx
	pop %ecx
	pop %ebx
	pop %eax
	ret

# Main application.
_start:
	# Print the explanation message
	movl $len1, %edx # Push string lenght as 3rd argument
	movl $help, %ecx # Push string pointer as 2nd argument
	movl $1, %ebx 	# Push channel (1 = stdout) as 1st argument
	movl $4, %eax 	# Call 'write' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Read the string
	movl $len2,	%edx # Push long type lenght as 3rd argument
	movl $string, %ecx # Push buffer pointer as 2nd argument
	movl $0, %ebx 	# Push channel (0 = stdin) as 1st argument
	movl $3, %eax 	# Call 'read' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Print reversed string
	movl $string, %ebx
	call reverse_string
	# Exit successfully
	movl $0, %ebx	# Successful exit
	movl $1, %eax	# Syscall code for exit
	int $0x80

.data
help: .ascii "Type string to reverse: "
	len1 = . - help # From here to the start of the string... it is the string length!
string: .ascii "                                        "
	len2 = . - string # From here to the start of the string... it is the string length!
