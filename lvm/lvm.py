KD = 10 # Max length of function vector
KM = 100 # Max length of memory vector

D = [0]*KD
M = [None]*KM
I = {}
sp = -1
pc = 0

def _ldc(k): 
  global sp, M
  sp = sp + 1
  M[sp] = k

def _ldv(i, j): 
  global sp, D, M
  sp = sp + 1
  M[sp] = M[D[i] + j]

def _ldr(i, j): 
  global sp, D, M
  sp = sp + 1
  M[sp] = D[i] + j

def _stv(i, j): 
  global sp, D, M
  M[D[i] + j] = M[sp]
  sp = sp - 1

def _lrv(i, j): 
  global sp, D, M
  sp = sp + 1
  M[sp] = M[M[D[i] + j]]

def _srv(i, j): 
  global sp, D, M
  M[M[D[i] + j]] = M[sp]
  sp = sp - 1

def _add(): 
  global sp, M
  M[sp - 1] = M[sp - 1] + M[sp]
  sp = sp - 1

def _sub(): 
  global sp, M
  M[sp - 1] = M[sp - 1] - M[sp]
  sp = sp - 1

def _mul(): 
  global sp, M
  M[sp - 1] = int(M[sp - 1] * M[sp])
  sp = sp - 1

def _div(): 
  global sp, M
  M[sp - 1] = int(M[sp - 1] / M[sp])
  sp = sp - 1

def _mod(): 
  global sp, M
  M[sp - 1] = M[sp - 1] % M[sp]
  sp = sp - 1

def _neg(): 
  global sp, M
  M[sp] = -M[sp]

def _and(): 
  global sp, M
  M[sp - 1] = M[sp - 1] and M[sp]
  sp = sp - 1

def _lor(): 
  global sp, M
  M[sp - 1] = M[sp - 1] or M[sp]
  sp = sp - 1

def _not():
  global sp, M
  M[sp] = not M[sp]

def _les(): 
  global sp, M
  M[sp - 1] = M[sp - 1] < M[sp]
  sp = sp - 1

def _leq(): 
  global sp, M
  M[sp - 1] = M[sp - 1] <= M[sp]
  sp = sp - 1

def _grt(): 
  global sp, M
  M[sp - 1] = M[sp - 1] > M[sp]
  sp = sp - 1

def _gre(): 
  global sp, M
  M[sp - 1] = M[sp - 1] >= M[sp]
  sp = sp - 1

def _equ(): 
  global sp, M
  M[sp - 1] = M[sp - 1] == M[sp]
  sp = sp - 1

def _neq(): 
  global sp, M
  M[sp - 1] = M[sp - 1] != M[sp]
  sp = sp - 1

def _jmp(p): 
  global I, pc
  pc = I[p]

def _jof(p):
  global sp, pc, M, I
  if not M[sp]:
    pc = I[p]
  sp = sp - 1

def _alc(n): 
  global sp
  sp = sp + n

def _dlc(n): 
  global sp
  sp = sp - n

def _cfu(p): 
  global sp, pc, M
  sp = sp + 1
  M[sp] = pc + 1
  pc = p-1

def _enf(k): 
  global sp, D, M
  sp = sp + 1
  M[sp] = D[k]
  D[k] = sp + 1

def _ret(k, n): 
  global sp, pc, D, M
  D[k] = M[sp]
  pc = M[sp - 1] - 1
  sp = sp - (n + 2)

def _idx(k): 
  global sp, M
  M[sp - 1] = M[sp - 1] + M[sp] * k
  sp = sp - 1

def _grc(): 
  global sp, M
  M[sp] = M[M[sp]]

def _lmv(k): 
  global sp, M
  t = M[sp]
  M[sp:sp+k] = M[t:t+k]
  sp += (k-1)

def _smv(k): 
  global sp, M
  t = M[sp - k]
  M[t:t+k] = M[sp-k+1:sp+1]
  sp -= (k + 1)

def _smr(k): 
  global sp, M
  t1 = M[sp - 1]
  t2 = M[sp]
  M[t1:t1+k] = M[t2:t2+k]
  sp -= 1

def _sts(k): 
  global sp, M, H
  adr = M[sp]
  M[adr] = len(H[k])
  for c in H[k]:
      adr = adr + 1
      M[adr] = c;
  sp = sp - 1

def _rdv(): 
  global sp, M
  sp = sp + 1
  M[sp] = int(input().strip())

def _rds(): 
  global sp, M
  str = input()
  adr = M[sp]
  M[adr] = len(str)
  for k in str:
      adr = adr + 1
      M[adr] = k
  sp = sp - 1

def _prv(): 
  global sp, M
  print(M[sp])
  sp = sp - 1

def _prt(k): 
  global sp, M
  data = [repr(x) for x in M[sp-k+1:sp+1]]
  print(','.join(data))
  sp -= k

def _prc(i): 
  global H
  print(H[i])

def _prs(): 
  global sp, M
  adr = M[sp]
  len = M[adr]
  for i in range(0, len):
     adr = adr + 1
     print(M[adr])
  sp = sp - 1

def _stp(): 
  global sp, D
  sp = -1
  D[0] = 0

def _lbl(i): 
  pass

def _end(): 
  global pc
  pc = -1

instructionMap = { 'ldc': _ldc,  'ldv': _ldv, 'ldr': _ldr,  'stv': _stv,  'lrv': _lrv,  'srv': _srv, 'add': _add, 'sub': _sub,  'mul': _mul,  'div': _div,  'mod': _mod,  'neg': _neg, 'and': _and,  'lor': _lor, 'not': _not, 'les': _les,  'leq': _leq,  'grt': _grt,  'gre': _gre,  'equ': _equ,  'neq': _neq,  'jmp': _jmp, 'jof': _jof, 'alc': _alc,  'dlc': _dlc,  'cfu': _cfu, 'enf': _enf,  'ret': _ret,  'idx': _idx, 'grc': _grc,  'lmv': _lmv,  'smv': _smv, 'smr': _smr,  'sts': _sts,  'rdv': _rdv,  'rds': _rds,  'prv': _prv, 'prt': _prt,  'prc': _prc, 'prs': _prs, 'stp': _stp, 'lbl': _lbl, 'end': _end }

if __name__ == "__main__":
  import sys

  #H, P must be defined on file!!!!
  try:
    lf = open(sys.argv[1])
    exec(lf.read())
  except:
    print("Please enter the command like this: {} Lya_code_location".format(sys.argv[0]))
    sys.exit()
  #print(H, P)

  for instruction in P:
    if instruction[0] == 'lbl':
      I[instruction[1]] = pc
    pc += 1

  pc = 0
  while pc >= 0:
    instruction = P[pc]
    name_instruction = instruction[0]
    function_args = instruction[1:]
    #print(instruction)
    instructionMap[name_instruction](*function_args)
    pc = pc + 1 if pc >= 0 else -1

