// Solvers for dinamic programming problems

int knapsack_simple(int n, int num_obj, int values_obj[], int weigth[], int values[]){
    int i, j;
    for(i=0; i <= n; i++)
        for(j=0; j < num_obj; j++)
            if(i+weigth[j] <= n)
                if(values[i]+values_obj[j] > values[i+weigth[j]])
                    values[i+weigth[j]]=values[i]+values_obj[j];
    return values[n];
}

int knapsack_hard(int n, int num_obj, int values_obj[], int weigth[], int values[][]){
    int i, j;
    for(j=0; j <= num_obj; j++)
        for(i=0; i <= n; i++){
            values[i][j+1]=values[i][j];
            if(i+weight[j] < n)
                if(values[i][j]+values_obj[j] > values[i+weight[j]][j+1])
                    values[i+weight[j]][j+1]=values[i][j]+values_obj[j];
    }
    return values[n][num_obj];
}

int scheduling(int n, int values[], int previous[], int results[]){
    return values[n]+results[previous[n-1]] > results[n-1] ? values[n]+results[previous[n-1]] : results[n-1];
}
