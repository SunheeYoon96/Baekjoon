#include <iostream>
#include <vector>

using namespace std;

int N{};
int streak{}, maxStreak{}, fixDay{-2}, val{};
bool canFreeze{true};

int main()
{
    cin >> N;
    
    for (int i=0; i<N; i++) {
        cin >> val;
        
        if(val==0){
            if(canFreeze) {
                canFreeze = false;
                fixDay = i;
            }else{
                if(i>=fixDay+2){
                    fixDay = i;
                }else{
                    maxStreak = max(streak, maxStreak);
                    streak = 0;
                }
            }
        }else{
            streak++;
        }
    }
    maxStreak = max(streak, maxStreak);
    cout << maxStreak << "\n";
}