#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int K{}, N{}, x{}, y{}, num{};
vector<vector<int>> map;

bool isHole(int r, int c, int size)
{
    for (int i=r; i < r+size; i++) {
        for (int j=c; j<c+size; j++) {
            if(map[i][j] != 0) return false;
        }
    }
    return true;
}

void tilling(int r, int c, int size)
{
    num++;
    int half = size/2;
    if(isHole(r, c, half)){
        map[r+half-1][c+half-1] = num;
    }
    if(isHole(r+half, c, half)){
        map[r+half][c+half-1] = num;
    }
    if(isHole(r, c+half, half)){
        map[r+half-1][c+half] = num;
    }
    if(isHole(r+half, c+half, half)){
        map[r+half][c+half] = num;
    }
    
    if(half==1) return;
    
    tilling(r, c, half);
    tilling(r+half, c, half);
    tilling(r, c+half, half);
    tilling(r+half, c+half, half);
}

void printFloor()
{
    for (int r=N; r>=1; r--) {
        for (int c=1; c<=N; c++) {
            cout << map[r][c] <<" ";
        }
        cout << "\n";
    }
}

int main()
{
    cin >> K;
    N = static_cast<int>(pow(2, K));
    cin >> x >> y;
    
    map.resize(N+1, vector<int>(N+1,0));
    map[y][x] = -1; //왼쪽 아래에서 시작하니까 반대로 넣어줌
    
    tilling(1,1,N);
    printFloor();
}