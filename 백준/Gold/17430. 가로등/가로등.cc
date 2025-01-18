#include <iostream>
#include <map>
#include <set>

using namespace std;

int main() {
    int T;
    cin >> T;

    while (T--) {
        ios_base :: sync_with_stdio(false);
        cin.tie(NULL);
        cout.tie(NULL);
        
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

        for (auto& [x, yList] : streetLamps) {
            if (yList != group) {
                isBalanced = false;
                break;
            }
        }

        cout << (isBalanced ? "BALANCED" : "NOT BALANCED") << "\n";
    }
}