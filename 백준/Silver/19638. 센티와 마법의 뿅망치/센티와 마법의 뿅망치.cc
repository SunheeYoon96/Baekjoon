#include <iostream>
#include <queue>

using namespace std;

int main()
{
    int N{0}, H{0}, T{0};
    priority_queue<int>giantHeights;
    
    cin >> N >> H >> T;
    
    int value{0};
    for(int n=0; n<N; n++){
        cin >> value;
        giantHeights.push(value);
    }
    
    int cnt{0};
    for(int t=0; t<T; t++){
        auto tallest = giantHeights.top();
        
        if(H > tallest)
        {
            //할 필요 없음
        }
        else{
            giantHeights.pop();
            
            if(tallest > 1)
            {
                giantHeights.push(tallest/2);
                cnt++;
            }
            else{
                giantHeights.push(tallest);
            }
        }
        
    }
    
    if(H > giantHeights.top())
    {
        cout << "YES" << "\n" << cnt << "\n";
    }
    else
    {
        cout << "NO" << "\n" << giantHeights.top() << "\n";
    }
    
}