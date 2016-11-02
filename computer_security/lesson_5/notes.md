# Differenze tra x86 e x86_64
syscall code: 59
Registri diversi per caricare le syscalls

# Nyan derp
./ex_5.9_insecure $(perl -e 'print "A"x264') <- da provare lol

# Note nella conversione
In quanto usiamo stringe, dobbiamo evitare \x00 che è terminatore
Quindi modifichiamo il codice per non averne
Tipo
movq $0, %reg -> xorq %reg, %reg  # Evitiamo zeri resettando i registri
movq $int, %rax -> movb $int, %al # Spostiamo bytes
Ed inoltre, per caricare la stringa di eseguibile
pop %rdi -> la stringa del comando da eseguire è sullo stack, quindi faccio la pop diretta
