#include <iostream>
#include <fstream>
#include <iomanip>
#include <string>
#include <stdlib.h>
#include <cmath>
using namespace std;
int main(void)
{
    string binary = " ";
    int decimal = 0;
    int base = 0;
    
    {
    cout << "Please enter a binary number to convert to decimal" 
<< endl;
    cin >> binary; //it will take in the binary number
        for(int i = binary.size() - 1; i >= 0; i--)
        {
     
          if(binary [i] == 49) //ASCII number for 1
            {
                decimal = decimal + pow(2, base); //pow = base and power
            }
        base++;
        }
        cout << "The decimal is " << decimal << endl;;
    
    }
    
        return 0;
    }
