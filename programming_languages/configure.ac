#                                               -*- Autoconf -*-
# Process this file with autoconf to produce a configure script.

AC_PREREQ([2.69])
AC_INIT([programming-languages], [1.0], [giovannisantini93@yahoo.it])
AC_CONFIG_MACRO_DIR([m4])
AM_INIT_AUTOMAKE([-Wall -Werror foreign])
LT_INIT

# Checks for programs.
# Autoscan wanted ones.
AC_PROG_CXX
AC_PROG_AWK
AC_PROG_CC
AC_PROG_CPP
AC_PROG_INSTALL
AC_PROG_LN_S
AC_PROG_MAKE_SET
AC_PROG_RANLIB
# What we need.
AC_ERLANG_NEED_ERLC
AC_PROG_OCAML
AX_PROG_SCALA

AC_CONFIG_FILES([Makefile
                 erlang/Makefile
                 ocaml/Makefile
                 scala/Makefile])
AC_OUTPUT
