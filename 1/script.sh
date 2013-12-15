#!/bin/bash

echo 'Iniziamo il cazzeggio'

for i in {1..100}
do
	touch $i.txt
	echo "Ciao mondo!" >> $i.txt
done

if [[ $1 = "c" ]]; then
	rm *.txt
	echo 'Tutti i files rimossi!'
	exit;
fi

echo 'Ora hai 100 files... Buona cancellazione! :D'
echo 'P.S. Scopri il segreto per togliere i 100 files con la magiaaaaa'
exit
