# We want our print executable!
apps = candy_shell_64 exec_shell getenvaddr
insecure = ex_5.9
insecure-targets = $(insecure:=_insecure)
asm = 
default: $(apps) $(asm) $(insecure-targets)

print-targets:
	@echo $(insecure) to $(insecure-targets)

# Compilation flags
ASFLAGS = --64 --gstabs
CCFLAGS = -m64 -ggdb
INSECURE_CCFLAGS = $(CCFLAGS) -fno-stack-protector -z execstack -mpreferred-stack-boundary=4
LDFLAGS = -melf_x86_64

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
