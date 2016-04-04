# Exercise specific Makefile.
# Wrote following this tutorial:
# https://rwmj.wordpress.com/2009/03/31/using-autoconf-for-ocaml-projects/
bin_SCRIPTS = exercise_1$(EXEEXT)

exercise_1$(EXEEXT): exercise_1.cmo
	$(OCAMLC) $^ -o $@

.ml.cmo:
	$(OCAMLC) -c $< -o $@

EXTRA_DIST = exercise_1.ml

CLEANFILES = *.cmi *.cmo $(bin_SCRIPTS) *~
