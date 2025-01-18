#include <iostream>
#include <map>
#include <set>
using namespace std;

int main() {
    ios_base :: sync_with_stdio(false); 
    cin.tie(NULL); 
    cout.tie(NULL);
    
    int T;
    cin >> T;

    while (T--) {
        int N;
        cin >> N;

        map<int, set<int>> streetLamps;

        for (int i = 0; i < N; ++i) {
            int x, y;
            cin >> x >> y;
            streetLamps[x].insert(y);
        }

        set<int> group = streetLamps.begin()->second;

        bool isBalanced = true;

        // 각 x 그룹의 y 값 패턴 비교
        for (auto& [x, yList] : streetLamps) {
            if (yList != group) {
                isBalanced = false;
                break;
            }
        }

        cout << (isBalanced ? "BALANCED" : "NOT BALANCED") << "\n";
    }
}