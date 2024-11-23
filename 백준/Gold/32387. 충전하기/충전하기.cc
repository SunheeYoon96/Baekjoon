#include <iostream>
#include <queue>
#include <vector>
#include <set>

using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int N, Q;
    cin >> N >> Q;

    vector<int> portState(N + 1, 0);
    vector<int> log(N + 1, 0);

    set<int> availablePorts;
    for (int i = 1; i <= N; ++i) {
        availablePorts.insert(i);
    }

    int cnt = 0;

    while(Q--){
        int cmd, i;
        cin >> cmd >> i;
        cnt++;

        if (cmd == 1) {
            if (portState[i] == 0) {
                portState[i] = 1;
                log[i] = cnt;
                availablePorts.erase(i);
                cout << i << '\n';
            } else {
                auto it = availablePorts.lower_bound(i);
                if (it == availablePorts.end()) {
                    cout << -1 << '\n';
                } else {
                    int port = *it;
                    availablePorts.erase(it);
                    portState[port] = 1;
                    log[port] = cnt;
                    cout << port << '\n';
                }
            }
        } else if (cmd == 2) {
            if (portState[i] == 1) {
                cout << log[i] << '\n';
                portState[i] = 0;
                availablePorts.insert(i);
            } else {
                cout << -1 << '\n';
            }
        }
    }
}