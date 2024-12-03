#include <iostream>
#include <string>
#include <cmath>

using namespace std;

int main()
{
    string str;
    cin >> str;
    
    char current {'A'};
    int time {0};
    
    for (auto ch : str) {
        int right = abs(current - ch);
        int left = 26-right;
        time += min(right, left);
        current = ch;
    }
    
    cout << time;
    
}