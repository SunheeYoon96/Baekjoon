#include <iostream>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n,m;
    cin >> n >> m;
    
    int endValue = n-m;
    
    for(int i=0; i<endValue; i++)
    {
        cout << i << " " << i+1 << "\n";
    }
    
    for(int j=endValue+1; j<n; j++)
    {
        cout << endValue << " " << j << "\n";
    }
}