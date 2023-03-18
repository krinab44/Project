#include <iostream>
#include <math.h>
#include <iomanip>
using namespace std;
//functions
double log2n(double comp_timex,double y, double  x);
double n(double x, double y);
double nlogn(double comp_timex,double y, double x);
double n_squared(double x, double y);
double n_cubed(double x, double y);
double factorial(double x, double y);
double two_raised(double x, double y);
double conversion_time(double n);
string time_measurement (double n);
int main (void)
{
    double comp_time;
    int low;
    int medium;
    int high;
    double answer;
    double result;
    int conversion;
    cout << "please enter a time in seconds" << endl;
    cin >> comp_time;
    cout << "Please enter a low" << endl;
    cin >> low;
    cout << "Please enter a medium" << endl;
    cin >> medium;
    cout << "Please enter a high" << endl;
    cin >> high;
    cout << endl;
    
    //start of calculations
    double logn = log2n(comp_time,low, 2);
    double var_n = n(comp_time, low);
    double n_times_logn = nlogn(comp_time,low,2);
    double nsqaured = n_squared(comp_time, low);
    double ncubed = n_cubed(comp_time, low);
    double fact = factorial(comp_time,low);
    double tworaise = two_raised(comp_time, low);
    
    double logn2 = log2n(comp_time,medium, 2);
    double var_n2 = n(comp_time, medium);
    double n_times_logn2 = nlogn(comp_time,medium,2);
    double nsqaured2 = n_squared(comp_time, medium);
    double ncubed2 = n_cubed(comp_time, medium);
    double fact2 = factorial(comp_time,medium);
    double tworaise2 = two_raised(comp_time, medium);
    
    double logn3 = log2n(comp_time,high, 2);
    double var_n3 = n(comp_time, high);
    double n_times_logn3 = nlogn(comp_time,high,2);
    double nsqaured3 = n_squared(comp_time, high);
    double ncubed3 = n_cubed(comp_time, high);
    double fact3 = factorial(comp_time,high);
    double tworaise3 = two_raised(comp_time, high);
    
    //start of table
    cout << right;
    cout << fixed << setprecision(6);
cout <<
    setw(25) << "Low = " << low << setw(28) << "Medium = " << medium << 
setw(28) << "High = " << high << '\n' <<
        setw(10) << "Log(n)" << setw(15) << conversion_time(logn) << " " << 
time_measurement(logn) << setw(25) << conversion_time(logn2) << " " << 
time_measurement(logn2) << setw(25) << conversion_time(logn3) << " " << 
time_measurement(logn3) << endl <<
        setw(10) << "n" << setw(15) << conversion_time(var_n) << " " << 
time_measurement(var_n) << setw(25) << conversion_time(var_n2) << " " << 
time_measurement(var_n2) << setw(25) << conversion_time(var_n3) << " " << 
time_measurement(var_n3) << endl <<
        setw(10) << "Nlog(n)" << setw(15) << conversion_time(n_times_logn) << " " 
<< time_measurement(n_times_logn) << setw(25) << conversion_time(n_times_logn2) << 
" " << time_measurement(n_times_logn2) << setw(25) << 
conversion_time(n_times_logn3) << " " << time_measurement(n_times_logn3) << endl <<
        setw(10) << "n^2" << setw(15) << conversion_time(nsqaured) << " " << 
time_measurement(nsqaured) << setw(25) << conversion_time(nsqaured2) << " " << 
time_measurement(nsqaured2) << setw(25) << conversion_time(nsqaured3) << " " << 
time_measurement(nsqaured3) << endl <<
        setw(10) << "n^3" << setw(15) << conversion_time(ncubed) << " " << 
time_measurement(ncubed) << setw(25) << conversion_time(ncubed2) << " " << 
time_measurement(ncubed2) << setw(25) << conversion_time(ncubed3) << " " << 
time_measurement(ncubed3) << endl <<
        setw(10) << "n!" << setw(15) << conversion_time(fact) << " " << 
time_measurement(fact) << setw(25) << conversion_time(fact2) << " " << 
time_measurement(fact2) << setw(25) << conversion_time(fact3) << " " << 
time_measurement(fact3) << endl <<
        setw(10) << "2^n" << setw(15) << conversion_time(tworaise) << " " << 
time_measurement(tworaise) << setw(25) << conversion_time(tworaise2) << " " << 
time_measurement(tworaise2) << setw(25) << conversion_time(tworaise3) << " " << 
time_measurement(tworaise3) << endl;
}
//start of functions
double log2n(double comp_timex,double y, double  x)
{
    //x = 2;
    double answer= log(y) / log(x);
    return comp_timex*answer;
}
double n(double x, double y)
{
    double answer = x * y;
    return answer;
}
double nlogn(double comp_timex,double y, double x)
{
    //x = 2;
    double answer= (log(y) / log(x)) * y;
    return comp_timex*answer;
}
double n_squared(double x, double y)
{
    double answer = x * (y*y);
    return answer;
}
double n_cubed(double x, double y)
{
    double answer = x * (y*y*y);
    return answer;
}
double factorial(double x, double y)
{
   int counter;
   long fact = 1;
    for (int counter = 1; counter <= y; counter++) 
    {
        fact = fact * counter;
    }
    double answer = fact * x;
    return answer;
}
double two_raised(double x, double y)
{
    double result = pow(2,y);
    double answer = result * x;
    return answer;
}
double conversion_time(double n)
{
    if (n < 60 && n >= 0)
    {
        double secs = n;
        return secs;
        
    }
    else if (n >= 60 && n < 3600)
    {
        double mins = n/60;
        return mins;
    }
    else if(n >= 3600 && n < 86400)
    {
        double hours = n/3600;
        return hours;
    }
    else if(n >= 86400 && n < 31536000)
    {
        double days = n/86400;
        return days;
    }
    else if(n >= 31536000 && n < 3153600000)
    {
        double years = n/31536000;
        return years;
    }
    else if(n >= 3153600000 && n < 3154000000000)
    {
        double cent = n/3153600000;
        return cent;
    }
    else
    {
        cout << "over 1K cent. " << endl;
        
    }
}
string time_measurement (double n)
{
    if (n < 60 )
    {
        float secs = n;
        string seconds = "secs";
        return seconds;
        
    }
    else if (n >= 60 && n < 3600)
    {
        double mins = n/60;
        string minutes = "minute";
        return minutes;
        
    }
    else if(n >= 3600 && n < 86400)
    {
        double hours = n/3600;
        string hour = "hour";
        return hour;
        
    }
    else if(n >= 86400 && n < 31536000)
    {
        double days = n/86400;
        string day = "day";
        return day;
        
    }
    else if(n >= 31536000 && n < 3153600000)
    {
        double years = n/31536000;
        string year = "year";
        return year;
        
    }
    else if(n >= 3153600000 && n < 3154000000000)
    {
        double cent = n/3153600000;
        string century = "century";
        return century;
        
    }
    // else
    // {
    //     //cout << "you have exceeded 1000 cent" << endl;
        
    // }
} 
