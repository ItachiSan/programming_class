Download: http://security.di.unimi.it/sicurezza1314/samples.tar.gz

Soluzioni:
1. Vengono usate
   * 2 variabili locali, 1 int ed 1 char[256]
     in quanto pusho 16 a -0x4(ebp)
     e 'A' (0x41) e 'B' (0x42) a -0x104/103(ebp)
   * 2 variabili globali char
     in quanto pusho 'D' (0x44) ed 'E' (0x45) a due indirizzi
2. Vengono passati 3 parametri
   * Un char:
     movl $0x41,0x8(%esp)
   * Un array con relativa lunghezza
     movl $0x64,0x4(%esp)
     lea  -0x64(%ebp),%eax
     mov  %eax,(%esp)
   Essenzialmente, è un ciclo while che riempie il buffer
   passato come parametro del carattere passato come parametro
3. I costrutti usati sono:
   * sampleC: if-else con stampa di stringa (diverse per i diversi branch)
   * sampleD: while
   * sampleE: switch-case (e altro...?)

