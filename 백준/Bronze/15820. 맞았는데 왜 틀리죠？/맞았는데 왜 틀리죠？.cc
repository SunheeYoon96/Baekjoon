#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int s1, s2;
    cin >> s1 >> s2;
    
    while (s1-- > 0) {
        int x,y;
        cin >> x >> y;
        
        if(x != y)
        {
            cout << "Wrong Answer";
            return 0;
        }
    }
    
    while (s2-- > 0) {
        int x,y;
        cin >> x >> y;
        if(x != y)
        {
            cout << "Why Wrong!!!";
            return 0;
        }
    }
    
    cout << "Accepted";
    
}