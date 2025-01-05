#include <iostream>
#include <vector>
#include <string>
#include <cmath>

using namespace std;

const int LED[10][10] = {
    {0, 4, 3, 3, 4, 3, 2, 3, 1, 2},
    {4, 0, 5, 3, 2, 5, 6, 1, 5, 4},
    {3, 5, 0, 2, 5, 4, 3, 4, 2, 3},
    {3, 3, 2, 0, 3, 2, 3, 2, 2, 1},
    {4, 2, 5, 3, 0, 3, 4, 3, 3, 2},
    {3, 5, 4, 2, 3, 0, 1, 4, 2, 1},
    {2, 6, 3, 3, 4, 1, 0, 5, 1, 2},
    {3, 1, 4, 2, 3, 4, 5, 0, 4, 3},
    {1, 5, 2, 2, 3, 2, 1, 4, 0, 1},
    {2, 4, 3, 1, 2, 1, 2, 3, 1, 0}
};
int N, K, P, X;

int calcuChangedLED(const string num1, const string num2, int K) {
    int cnt = 0;
    for (int i = 0; i < K; i++) {
        int digit1 = num1[i] - '0';
        int digit2 = num2[i] - '0';
        cnt += LED[digit1][digit2];
    }
    return cnt;
}

string fixedLength(int num, int K) {
    string result = to_string(num);
    while (result.size() < K) {
        result = "0" + result;
    }
    return result;
}

int main() {
    cin >> N >> K >> P >> X;

    int cnt = 0;
    string current = fixedLength(X, K);

    for (int i = 1; i <= N; i++) {
        if (i == X) continue;

        string target = fixedLength(i, K);
        int reverseCnt = calcuChangedLED(current, target, K);

        if (reverseCnt > 0 && reverseCnt <= P) {
            cnt++;
        }
    }

    cout << cnt;
}