#!/usr/bin/env python

from z3 import *
from sys import argv

def hash_pass(psw):
	return sum([x * (-1)**i for i,x in enumerate(psw)])

def hash_user(user):
	return user[0] + hash_pass(user[1:])

user_len = 7
psw_len = 7

if len(argv) == 3:
	user_len = int(argv[1])
	psw_len = int(argv[2])

user = IntVector('user', user_len)
psw = IntVector('psw', psw_len)
s = Solver()

s.add(sum(user) == sum(psw))
s.add(hash_user(user) == hash_pass(psw))
s.add(And([i == j or user[i] != user[j] for i in range(len(user)) for j in range(len(user))]))
s.add(And([i == j or psw[i] != psw[j] for i in range(len(psw)) for j in range(len(psw))]))
s.add(And([user[i] != psw[j] for i in range(len(user)) for j in range(len(psw))]))

s.add(And([i <= 122 for i in user]))
s.add(And([97 <= i for i in user]))
s.add(And([97 <= i for i in psw]))
s.add(And([i <= 122 for i in psw]))

s.add(psw[0] >= psw[-1])
s.add(And([psw[i] < psw[i+2] for i in range(2, len(psw)-2, 2)]))
s.add(And([psw[i] > psw[i+2] for i in range(1, len(psw)-2, 2)]))

r = sat
last = None
while r == sat:
    if last is not None:
        # add last solution as new constraint
        s.add(Or([i != j for i, j in zip(user, last['user'])]))
        s.add(Or([i != j for i, j in zip(psw, last['psw'])]))
    
    r = s.check()
    print(r, end="")
    
    if r == sat:
        m = s.model()

        last = {}
        last['user'] = [m.evaluate(e) for e in user]
        last['psw'] = [m.evaluate(e) for e in psw]
        u = ''.join([chr(m.evaluate(e).as_long()) for e in user])
        p = ''.join([chr(m.evaluate(e).as_long()) for e in psw])
        print(" -> \tUser: {} | Pass: {}".format(u, p))
