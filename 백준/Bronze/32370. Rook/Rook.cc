#include <iostream>

using namespace std;

int main()
{
    int a,b,x,y;
    cin >> a >> b >> x >> y;
    
    int rookX{0}, rookY{0};
    int moveCnt{0};
    
    if(rookX==a)
    {
        if(a!=x || (a==x && b<y)) moveCnt = 1;
        else moveCnt = 3;
    }
    else if(rookY==b)
    {
        if(b!=y || (b==y && a<x)) moveCnt = 1;
        else moveCnt = 3;
    }
    else
    {
        moveCnt = 2;
    }
    
    cout << moveCnt << endl;
}