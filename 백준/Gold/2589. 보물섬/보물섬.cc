#include <iostream>
#include <queue>

using namespace std;

char map[50][50];
int visited[50][50];
int N{}, M{}, ans{};
int deltas[4][2] = {{1,0},{-1,0},{0,-1},{0,1}};

bool isIn(int nr, int nc)
{
    if(nr<0 || nr>=N || nc<0 || nc>=M) return false;
    return true;
}

int bfs(int r, int c)
{
    int maxLen{};
    queue<pair<int, int>> que;
    que.push(make_pair(r, c));
    visited[r][c] = 0;
    
    while(!que.empty()){
        int currentR = que.front().first;
        int currentC = que.front().second;
        que.pop();
        
        if(maxLen < visited[currentR][currentC]) maxLen = visited[currentR][currentC];
        
        for (int d = 0; d<4; d++) {
            int nr = currentR + deltas[d][0];
            int nc = currentC + deltas[d][1];
            
            if(isIn(nr, nc)){
                if(visited[nr][nc]==-1 && map[nr][nc]=='L'){
                    que.push(make_pair(nr, nc));
                    visited[nr][nc] = visited[currentR][currentC]+1;
                }
            }
            
        }
    }
    return maxLen;
}

int main() {
    cin >> N >> M;
    
    fill_n(map[0], 50*50,'X');
    
    for(int r=0; r<N; r++){
        for (int c=0; c<M; c++) {
            cin >> map[r][c];
        }
    }
    
    for(int r=0; r<N; r++){
        for (int c=0; c<M; c++) {
            if(map[r][c]=='L'){
                fill_n(visited[0], 50*50, -1);
                int value = bfs(r, c);
                ans = max(ans, value);
            }
        }
    }
    cout << ans;
}