# Exercise specific Makefile.
# Wrote following this tutorial:
# https://rwmj.wordpress.com/2009/03/31/using-autoconf-for-ocaml-projects/
# Highly reworked though.

# Define properly objects extension and source
OBJEXT = cmo
SUFFIXES = .ml

# Section of program and test definition
bin_PROGRAMS = exercise_3
exercise_3_DEPENDENCIES = $(bin_PROGRAMS).$(OBJEXT)
exercise_3_SOURCES = $(bin_PROGRAMS).ml
TESTS = $(bin_PROGRAMS)

# Rule to compile objects
.ml.cmo:
	$(OCAMLC) -c $< -o $@

# Link in OCaML style
LINK= $(OCAMLC) $^ -o $@

# Files to clean up
CLEANFILES = *.cmi *.cmo $(bin_PROGRAMS) *~
