# Exercise specific Makefile.
# Wrote following this tutorial:
# http://lists.gnu.org/archive/html/automake/2002-09/msg00067.html
# Highly reworked though.

# Define properly objects extension and source
SUFFIXES = .erl

# Section of program and test definition
exercise = exercise_2
beamdir = $(bindir)
beam_DATA = $(exercise).beam
EXTRA_DIST = $(exercise).erl

# Rule to compile objects
.erl.beam:
	$(ERLC) -b beam $< $@

# Files to clean up
CLEANFILES = $(beam_DATA) *~
