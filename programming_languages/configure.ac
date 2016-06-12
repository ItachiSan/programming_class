#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([Programming Languages], [1.0], [giovannisantini93@yahoo.it])
AC_CONFIG_MACRO_DIR([m4])
AC_CONFIG_AUX_DIR([build-aux])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
LT_INIT

# Checks for programs we need.
AC_PROG_OCAML
AC_ERLANG_NEED_ERL
AC_ERLANG_NEED_ERLC
AX_PROG_SCALA
AX_PROG_SCALAC

AC_CONFIG_FILES([Makefile
                 ocaml/Makefile
                 ocaml/normal/Makefile
                 ocaml/normal/exercise_1/Makefile
                 ocaml/normal/exercise_2/Makefile
                 ocaml/normal/exercise_3/Makefile
                 erlang/Makefile
                 erlang/normal/Makefile
                 erlang/normal/exercise_1/Makefile
                 scala/Makefile])
AC_OUTPUT
