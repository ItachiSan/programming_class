# We want our print executable!
apps = ex_5.1 ex_5.2 
insecure = ex_5.3 ex_5.4
insecure-targets = $(insecure:=_insecure)
asm = 
default: $(apps) $(asm) $(insecure-targets)

# Compilation flags
ASFLAGS = --32 --gstabs
CCFLAGS = -m32 -ggdb
INSECURE_CCFLAGS = $(CCFLAGS) -fno-stack-protector -z execstack -mpreferred-stack-boundary=2
LDFLAGS = -melf_i386

# Compile insecure C applications
%_insecure: %.c
	$(CC) $(INSECURE_CCFLAGS) $^ -o $@

# Compile C applications
%: %.c
	$(CC) $(CCFLAGS) $^ -o $@

%: %.s
	$(AS) $(ASFLAGS) $^ -o $(^:.s=.o)
	$(LD) $(LDFLAGS) $(^:.s=.o) -o $@

%.s: %.c
	$(CC) $(CCFLAGS) -S $^ -o $@

clean:
	$(RM) $(apps) $(insecure-targets) $(asm) *.o
