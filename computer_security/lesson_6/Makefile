# We want our print executable!
apps = getenvaddr
insecure = ex_6.3
insecure-targets = $(insecure:=_insecure)
asm = 
default: $(apps) $(asm) $(insecure-targets)

print-targets:
	@echo $(insecure) to $(insecure-targets)

# Compilation flags
ASFLAGS = --32 --gstabs
CCFLAGS = -m32 -ggdb
INSECURE_CCFLAGS = $(CCFLAGS) -fno-stack-protector -mpreferred-stack-boundary=2
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
