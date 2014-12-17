#ifndef SOLVERS_H
#define SOLVERS_H
int knapsack_simple(int n, int num_obj, int values_obj[], int weigth[], int values[]);
//int knapsack_hard(int n, int num_obj, int values_obj[], int weigth[], int values[][]);
int scheduling(int n, int values[], int previous[], int results[]);
#endif
