// Krina Bhagat
// CS 317-02
// P1
#include <chrono> \\ required for timing measurements
#include <iomanip>
#include <iostream>
#include <string>
using namespace std;
using integer = long long int;
integer recursive(integer n, integer k) {
// INSERT CODE
if (n < k)
{
return 0;
}
else if (n == k || k == 0)
{
return 1;
}
else
{
return recursive(n - 1, k - 1) + recursive(n - 1, k);
}
}
integer alternate(integer n, integer k) {
// INSERT CODE
//pascal triangle
int res = 1;
if (n < k)
return 0;
if (n == k || k == 0)
{
return 1;
}
for (int i = 1; i <= k; i++)
{
//res = res * (n-i);
//res = res / (i+1);
res = res * n-- /i; //had to change it to this from the orginal bc of
overflow condition
}
return res;
}
int main(int count, char* text[]) {
enum { SUCCESS, USAGE, INPUT };
if (count != 3) {
cout << "usage: " << text[0] << " <n:integer> <k:integer>\n"
<< "example: " << text[0] << " 36 18\n";
return -USAGE;
}
try {
integer n = stoi(text[1]), k = stoi(text[2]);
auto methods = { alternate, recursive };
cout << setw(10) << "method" << setw(15) << "value of C(" << n << ','
<< k << ')' << setw(14) << "time (s)\n" << string(45, '-') << endl;
// iterate over the method references and output results
for (auto combination : methods) {
auto start = std::chrono::system_clock::now(); // timing start
auto value = combination(n, k); // method to time
auto stop = std::chrono::system_clock::now(); // timing stop
chrono::duration<double> time = stop - start; // timing measurement
cout << setw(10) << (recursive == combination ? "recursive" :
"alternate")
<< setw(20) << value << setw(14) << fixed << time.count() << endl;
}
return SUCCESS;
}
catch (...) {
cout << "error: possible bad input(s), \""
<< text[1] << "\" and/or \"" << text[2] << "\"\n";
return -INPUT;
}
}
