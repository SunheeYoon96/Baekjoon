#include <iostream>
#include <map>
#include <string>

using namespace std;

int romanToArabic(string roman) 
{
    map<char, int> romanValues;
    romanValues['I'] = 1;
    romanValues['V'] = 5;
    romanValues['X'] = 10;
    romanValues['L'] = 50;
    romanValues['C'] = 100;
    romanValues['D'] = 500;
    romanValues['M'] = 1000;

    int result = 0;
    int prevValue = 0;

    for (int i = roman.size()-1; i >= 0; i--) {
        int currentValue = romanValues[roman[i]];
        if (currentValue < prevValue) {
            //작은 숫자가 큰 수 앞인 경우
            result -= currentValue;
        } else {
            //큰 숫자가 작은수 앞인 경우
            result += currentValue;
        }
        prevValue = currentValue;
    }

    return result;
}

string arabicToRoman(int number) 
{
    map<int, string, greater<int>> romanMapping;
    romanMapping[1000] = "M";
    romanMapping[900] = "CM";
    romanMapping[500] = "D";
    romanMapping[400] = "CD";
    romanMapping[100] = "C";
    romanMapping[90] = "XC";
    romanMapping[50] = "L";
    romanMapping[40] = "XL";
    romanMapping[10] = "X";
    romanMapping[9] = "IX";
    romanMapping[5] = "V";
    romanMapping[4] = "IV";
    romanMapping[1] = "I";

    string roman = "";

    for (map<int, string>::iterator it = romanMapping.begin(); it != romanMapping.end(); it++) {
        while (number >= it->first) {
            roman += it->second;
            number -= it->first;
        }
    }

    return roman;
}

int main() 
{
    ios::sync_with_stdio(false);
    cin.tie(NULL);
    
    string roman1, roman2;
    cin >> roman1 >> roman2;

    int num1 = romanToArabic(roman1);
    int num2 = romanToArabic(roman2);
    int sum = num1 + num2;
    
    cout << sum << "\n";
    cout << arabicToRoman(sum) << "\n";

}