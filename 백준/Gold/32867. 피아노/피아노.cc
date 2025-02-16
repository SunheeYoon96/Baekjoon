#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int N, K;
    cin >> N >> K;
    
    vector<int> keys(N);
    for(int i=0; i<N; i++)
    {
        cin >> keys[i];
    }
    
    int moveCnt{};
    int idx{};
    
    while(idx < N)
    {
        int currentMin = keys[idx];
        int currentMax = keys[idx];
        int j = idx+1;
        
        while (j < N) 
        {
            currentMin = min(currentMin, keys[j]);
            currentMax = max(currentMax, keys[j]);
            
            if(currentMax - currentMin > K-1) break;
            
            j++;
        }
        
        if(j < N) moveCnt++;
        idx = j;
    }
    
    cout << moveCnt << "\n";
}