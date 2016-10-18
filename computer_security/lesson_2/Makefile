# We want our print executable!
apps = hello-world read-char reverse
insecure = stack1-stdin
insecure-targets = $(insecure:=_insecure)
asm = stack.s
default: $(apps) $(asm) $(insecure-targets)

test:
	@echo $(insecure) to $(insecure-targets)

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
