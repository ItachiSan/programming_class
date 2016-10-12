## Stack status after "bar"
'bar' call
__
20
__
EBP
__
EIP <-'foo' call
__
10

## "Nice" optimizations
CFLAGS = -fno-stack-protector -z execstack -m32
Then
`echo 0 | sudo cat > /proc/sys/kernel/randomize_va_space`
or
`sudo sysctl kernel.randomize_va_space=0`

## Inputs for challenges
### Challenge 1
aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaDCBA
