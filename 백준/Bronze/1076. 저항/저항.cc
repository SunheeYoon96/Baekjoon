#include <iostream>
#include <map>
#include <string>

using namespace std;

int main()
{
    map<string, pair<int, long long>> resistance;
    resistance.insert(make_pair("black", make_pair(0,1)));
    resistance.insert(make_pair("brown", make_pair(1,10)));
    resistance.insert(make_pair("red", make_pair(2,100)));
    resistance.insert(make_pair("orange", make_pair(3,1000)));
    resistance.insert(make_pair("yellow", make_pair(4,10000)));
    resistance.insert(make_pair("green", make_pair(5,100000)));
    resistance.insert(make_pair("blue", make_pair(6,1000000)));
    resistance.insert(make_pair("violet", make_pair(7,10000000)));
    resistance.insert(make_pair("grey", make_pair(8,100000000)));
    resistance.insert(make_pair("white", make_pair(9,1000000000)));
    
    string r1, r2, r3;
    long long ans{};
    
    cin >> r1 >> r2 >> r3;
    
    auto color = resistance[r1];
    int firstVal = color.first;
    color = resistance[r2];
    int secondVal = color.first;
    color = resistance[r3];
    long long thirdVal = color.second;
    ans = (firstVal*10 + secondVal) * thirdVal;
    
    cout << ans;
}