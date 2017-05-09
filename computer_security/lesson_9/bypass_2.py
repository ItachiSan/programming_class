"""
14/12/2016
Vedi: http://security.di.unimi.it/sicurezza1617/sec2.shtmls#calendario
Modulo per generare la password per aggirare il secondo programma.
Usiamo Z3!
Qui: https://github.com/Z3Prover/z3/tree/master/examples/python
"""

# Usiamo Z3!!!!
from z3 import Solver, IntVector, And

def checksum_username(username):
    return username[0] + checksum_password(username[1:])

def checksum_password(password):
    return sum([x * (-1 ** i) for i, x in enumerate(password)])


def bypass_2(username_size, password_size):
    """
    Funzione per generare una password corretta per lo username.
    INPUT
    username_size -> lunghezza accettata per lo username
    password_size -> lunghezza accettata per la password
    VINCOLI
    I vincoli identificati sono
    * Check in comune:
       - tra 5 e 8 caratteri
       - lowercase
       - charsum(user) = charsum(password)
       - caratteri non ripetuti
    * Check user:
      - checksum(user)
    * Check password:
      - inverso checksum(user)
      - caratteri in posizione pari decrescenti, in posizione dispari crescenti
      - primo e ultimo carattere diversi <- bypassata da 'caratteri non ripetuti'
    """
    solver = Solver()
    # Creiamo i campi di risoluzione
    username = IntVector('username', username_size)
    password = IntVector('password', password_size)
    # Aggiungiamo i vincoli...

    # Di lunghezza
    solver.add(len(username) >= 5 and len(username) <= 8)
    solver.add(len(password) >= 5 and len(password) <= 8)

    # Di carattere! Definiamo i caratteri come interi
    # e di conseguenza rispettiamo i vincoli vari
    # Caratteri più grandi di 'a' (ASCII code: 97)
    # Caratteri più piccoli di 'z' (ASCII code: 122)
    # Vogliamo i caratteri tra 'a' e 'z'!
    solver.add(And([i >= 97 and i <= 122 for i in username]))
    # Idem per la password
    solver.add(And([i >= 97 and i <= 122 for i in password]))

    # Caratteri non ripetuti per il nome utente
    solver.add(
        And([
            username[i] is not username[j] or i is j
            for i in range(len(username))
            for j in range(len(username))
        ])
    )
    # Caratteri non ripetuti per password
    solver.add(
        And([
            password[i] is not password[j] or i is j
            for i in range(len(password))
            for j in range(len(password))
        ])
    )
    # Caratteri non condivisi tra username e password
    solver.add(
        And([
            username[i] is not password[j]
            for i in range(len(username))
            for j in range(len(password))
        ])
    )

    # La somma dei caratteri di username e password deve essere uguale
    solver.add(sum(username) == sum(password))

    # Idem per il checksum
    solver.add(checksum_username(username) == checksum_password(password))

    

if __name__ == '__main__':
    i = input('Username: ')
    #p = bypass_2(i)
    #print(p)
    input('Tadah!')
