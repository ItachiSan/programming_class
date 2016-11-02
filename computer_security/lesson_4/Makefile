# We want our print executable!
apps = candy_print candy_shell getenvaddr exec_shell
insecure = test
insecure-targets = $(insecure:=_insecure)
asm = 
default: $(apps) $(asm) $(insecure-targets)

# Compilation flags
ASFLAGS = --32 --gstabs
CCFLAGS = -m32 -ggdb
INSECURE_CCFLAGS = $(CCFLAGS) -fno-stack-protector -z execstack
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
