#include <iostream>
#include <cmath>

using namespace std;

int main()
{
    int arr[11] = {0};
    int val{0};
    int minVal{1001};
    int ans{0};
    
    for (int i=0; i<10; i++) {
        cin >> val;
        arr[i+1] = arr[i]+val;
        if(minVal >= abs(arr[i+1]-100)){
            minVal = abs(arr[i+1]-100);
            ans = arr[i+1];
        }
    }
    cout << ans;
}