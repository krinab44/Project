#include <stdio.h>
#include <stdlib.h>
#include <time.h>
#include <string.h>
int main(void)
{
    //variables
    int whichplayercounter = 0;
    bool continuegame = true;
    int numplayer = 0;
    int quit;
    int test;
    int playerOneDiceOne;
    int playerOneDiceTwo;
    int playerTwoDiceOne;
    int playerTwoDiceTwo;
    int result1 = 0;
    int result2 = 0;
    
    srand((unsigned)time(NULL));
    //game rules
    printf("Welcome to the dice game of Fifty!\n You will need two players to play 
this game\n");
    printf("Goal: The goal of Fifty is to be the first player to reach 50 points.\n
You get points by rolling doubles.\n");
    printf("Play: The players decide who will be player 1 and who will be player 2.
\n Player 1 goes first. A turn consists of a player rolling a pair of dice (with 
the goal of rolling doubles) and scoring the roll as described below.\nPlay 
continues with each player taking one roll per turn. The first player to score 50 
or more points is declared the winner.\n");
    printf("Scoring: All doubles except 3s and 6s score 5 points. Double 6s are 
worth 25 points. Double 3s wipe out the players entire score, and the player must 
start again at 0. \nNon-double rolls are 0 points.\n");
    while (continuegame && (result2 < 50 && result1 < 50))
    {
        if (whichplayercounter % 2 == 0)
        {
            //printf("%d value of whichplayercounter\n", whichplayercounter);
            printf("Player 1 do you wish to continue? Press 1 to quit and 2 to continue.\n");
            scanf("%d", &quit);
            getchar();
            numplayer = 1;
            if (quit == 1)
            {
                continuegame = false;
                printf("Player 1 wants to quit, therefore player 2 wins\n");
                //end of game
            }
            if (quit != 1)
            {
                printf("Player 1's turn\n");
                playerOneDiceOne = rand() % 6 + 1;
                printf("Player 1: My first dice is %d\n", playerOneDiceOne);
                playerOneDiceTwo = rand() % 6 + 1;
                printf("Player 1: My second dice is %d\n", playerOneDiceTwo);
                if (playerOneDiceOne == playerOneDiceTwo)
                {
                    if (playerOneDiceOne == 6 && playerOneDiceTwo == 6)
                    {
                        result1 = result1 + 25;
                       //add 25 points to original score
                    }
                    else if (playerOneDiceOne == 3 && playerOneDiceTwo == 3)
                    {
                        result1 = 0;
                        printf("Your score is setting to 0 cuz you rolled two 3 \n");
                        //go back to zero
                    }
                    else
                    {
                        result1 = result1 + 5;
                        //add 5 points to origional score
                    }
                    
                }
                printf("Player 1 score is %d\n", result1);
            }
            whichplayercounter++;
        }
        else
        {
            //printf("%d value of whichplayercounter\n", whichplayercounter);
            printf("Player 2 do you wish to continue? Press 1 toc quit and 2 to continue.\n");
            scanf("%d", &test);
            getchar();
            numplayer = 2;
            if (test == 1)
            {
                continuegame = false;
                printf("Player 2 wants to quit, therefore Player 1 wins.\n");
                //end of game
                }
            if (test != 1)
            {
                printf("Player 2's turn\n");
                playerTwoDiceOne = rand() % 6 + 1;
                printf("Player 2: My first dice is %d\n", playerTwoDiceOne);
                playerTwoDiceTwo = rand() % 6 + 1;
                printf("Player 2: My second dice is %d\n", playerTwoDiceTwo);
                if (playerTwoDiceOne == playerTwoDiceTwo)
                {
                    if (playerTwoDiceOne == 6 && playerTwoDiceTwo == 6)
                    {
                        result2 = result2 + 25;
                        //add 25 points to origional score
                    }
                    else if (playerTwoDiceOne == 3 && playerTwoDiceTwo == 3)
                    {
                        result2 = 0;
                        //go back to 0
                        printf("Your score is setting to 0 cuz you rolled two 3 \n");
                    }
                    else
                    {
                        result2 = result2 + 5;
                        //add 5 points to original score
                    }
                }
                printf("Player 2 score is %d \n", result2);
            }
            whichplayercounter++;
        }
        
    }
    if (result1 >= 50)
    {
        printf("Player 1 wins!\n");
        
        int i;
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    }
    if (result2 >= 50) {
        printf("Player 2 wins!\n");
        
        int i;
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
    printf("\n\n");
    for (i=0; i < 20; i++)
    {
        printf("*");
    }
   
    }
    return 0;
}
