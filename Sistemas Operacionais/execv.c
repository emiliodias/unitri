#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <unistd.h>

int main(void)
{
    pid_t pid;

    if ((pid = fork()) < 0)
    {
        perror("fork");
        exit(1);
    }
    if (pid == 0)
    {
        //O código aqui dentro será executado no processo filho
        printf("pid do Filho: %d\n", getpid());
        char *args[]  = { "/tmp/comando", (char *) NULL };

        //Modifica a área de programa do processo
        execv("/tmp/comando", args);

    }
    else
    {
        //O código neste trecho será executado no processo pai
        printf("pid do Pai: %d\n", getpid());
    }


    printf("Esta regiao sera executada por ambos processos\n\n");
    while(1){}
    exit(0);
}
