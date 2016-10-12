# We want our print executable!
apps = hello-world read-char reverse
default: $(apps)

# Compilation flags
ASFLAGS = --32 --gstabs
CCFLAGS = -m32 -ggdb
LDFLAGS = -melf_i386

# Compile C applications
%: %.c
	$(CC) $(CCFLAGS) $^ -o $@

%: %.s
	$(AS) $(ASFLAGS) $^ -o $(^:.s=.o)
	$(LD) $(LDFLAGS) $(^:.s=.o) -o $@

clean:
	$(RM) $(apps) $(apps:=.o)
