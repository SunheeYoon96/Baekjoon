#include <iostream>
#include <string>
#include <vector>
#include <cmath>

using namespace std;

int N, dir;
int map[8][8];
string cmd, kingLocation, stoneLocation;
vector<vector<int>> deltas = {{0,1},{0,-1},{1,0},{-1,0},{-1,1},{-1,-1},{1,1},{1,-1}}; // R L B T RT LT RB LB

int changeDir(string cmd) {
    if(cmd == "R") return 0;
    if(cmd == "L") return 1;
    if(cmd == "B") return 2;
    if(cmd == "T") return 3;
    if(cmd == "RT") return 4;
    if(cmd == "LT") return 5;
    if(cmd == "RB") return 6;
    if(cmd == "LB") return 7;
    return -1;
}

bool isIn(int nr, int nc) {
    return nr >= 0 && nr < 8 && nc >= 0 && nc < 8;
}

int main() {
    cin >> kingLocation >> stoneLocation >> N;

    int kc = kingLocation[0] - 'A';
    int kr = abs(kingLocation[1] - '1' - 7);

    int sc = stoneLocation[0] - 'A';
    int sr = abs(stoneLocation[1] - '1' - 7);

    for (int i = 0; i < N; i++) {
        cin >> cmd;

        dir = changeDir(cmd);

        int nr = kr + deltas[dir][0];
        int nc = kc + deltas[dir][1];

        if (!isIn(nr, nc)) continue;

        // 움직인 위치가 돌이 있는 자리라면 돌을 킹이 움직인 방향과 같은 방향으로 이동시킴
        if (nr == sr && nc == sc) {
            int newsr = sr + deltas[dir][0];
            int newsc = sc + deltas[dir][1];

            if (!isIn(newsr, newsc)) continue;
            sr = newsr;
            sc = newsc;
        }

        kr = nr;
        kc = nc;
    }

    string finalKing = (char)(kc + 'A') + to_string(abs(kr - 7) + 1);
    string finalStone = (char)(sc + 'A') + to_string(abs(sr - 7) + 1);

    cout << finalKing << endl;
    cout << finalStone << endl;

    return 0;
}