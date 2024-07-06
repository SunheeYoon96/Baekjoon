#include <iostream>
#include <string>

using namespace std;

int main()
{
    int N = 0;
    int cnt = 0;
    bool flag = false;
    string str = "";
    
    cin >> N;
    
    while(cnt < N)
    {
        cin >> str;
        if(str == "anj") flag = true;
        cnt++;
    }
    
    if(flag) cout << "뭐야;" << endl;
    else cout << "뭐야?" << endl;
    
    return 0;
}