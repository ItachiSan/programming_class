.data
msg1: .ascii "Insert 1st number: "
	len1 = . - msg1 # From here to the start of the string... it is the string length!
msg2: .ascii "Insert 2nd number: "
	len2 = . - msg2 # As above, see 'len1'
int1: .long 0
int2: .long 0

.text
.global _start

# ASCII to integer function.
# Fetched from: http://stackoverflow.com/a/28202303
atoi:
	push %ebx			# preserve working registers
	push %edx
	push %esi

	mov $0, %eax		# initialize the accumulator
nxchr:
	mov $0, %ebx		# clear all the bits in EBX
	mov (%esi), %bl		# load next character in BL
	inc %esi			# and advance source index

	cmp $'0', %bl		# does character preceed '0'?
	jb inval			# yes, it's not a numeral jb:jump below
	cmp $'9', %bl		# does character follow '9'?
	ja inval			# yes, it's not a numeral ja:jump above

	sub $'0', %bl		# else convert numeral to int
	mull ten			# multiply accumulator by ten. %eax * 10
	add %ebx, %eax		# and then add the new integer
	jmp nxchr			# go back for another numeral

inval:
	pop	%esi			# recover saved registers
	pop	%edx
	pop	%ebx
	ret

_start:
	# Print 1st string
	movl $len1, %edx # Push string lenght as 3rd argument
	movl $msg1, %ecx # Push string pointer as 2nd argument
	movl $1, %ebx 	# Push channel (1 = stdout) as 1st argument
	movl $4, %eax 	# Call 'write' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Read 1st integer
	movl $4,	%edx # Push long type lenght as 3rd argument
	movl $int1, %ecx # Push buffer pointer as 2nd argument
	movl $0, %ebx 	# Push channel (0 = stdin) as 1st argument
	movl $3, %eax 	# Call 'read' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Print 2nd string
	movl $len2, %edx
	movl $msg2, %ecx
	movl $1, %ebx
	movl $4, %eax
	int $0x80
	# Read 2nd integer
	movl $4,	%edx
	movl $int2, %ecx
	movl $0, %ebx
	movl $3, %eax
	int $0x80
	# Subtract the number
	sub $int1, $int2
	# Print the result
	movl $4,	%edx # Push string lenght as 3rd argument
	movl $int1, %ecx # Push string pointer as 2nd argument
	movl $1, %ebx 	# Push channel (1 = stdout) as 1st argument
	movl $4, %eax 	# Call 'write' syscall
	int $0x80 		# Kernel interrupt for syscall
	# Exit successfully
	movl $1, %eax	# Syscall code for exit
	int $0x80

