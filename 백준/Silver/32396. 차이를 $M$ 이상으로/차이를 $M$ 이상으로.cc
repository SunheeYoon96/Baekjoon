#include <iostream>
#include <vector>
#include <cmath>

using namespace std;
using ll = long long;

int N{}, cnt{};
ll M{}, tmp{2222222222222};
vector<ll> arr;

int main()
{
    cin >> N >> M;
    
    arr.resize(N);
    
    for(int i=0; i<N; i++){
        cin >> arr[i];
    }
    
    for (int i=1; i<N; i++) {
        if(M > llabs(arr[i]-arr[i-1])){
            arr[i] += tmp;
            cnt++;
        }
    }
    
    cout << cnt;
}