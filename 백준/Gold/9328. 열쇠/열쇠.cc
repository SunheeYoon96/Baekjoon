#include <iostream>
#include <string>
#include <cstring>
#include <vector>
#include <algorithm>
#include <queue>
using namespace std;
int TC, H, W, ans;
char floorArea[102][102];
bool keys[26];
int deltas[4][2] = { {1,0},{-1,0},{0,1},{0,-1} };
struct Point {
 int r;
 int c;
};
bool isIn(int nr, int nc)
{
 if (nr < 0 || nr >= 102 || nc < 0 || nc >= 102) return false;
 return true;
}
void printFloor(char arr[102][102])
{
 for (int h = 0; h < 102; h++)
 {
  for (int w = 0; w < 102; w++)
  {
   cout << arr[h][w]<< " ";
  }
  cout << "\n";
 }
}
void findPaper()
{
 queue<Point> que;
 bool visited[102][102];
 fill(visited[0], visited[102], false);
 que.push({0,0});
 visited[0][0] = true;
 while (!que.empty())
 {
  Point current = que.front();
  que.pop();
  for (int d = 0; d < 4; d++)
  {
   int nr = current.r + deltas[d][0];
   int nc = current.c + deltas[d][1];
   if (!isIn(nr, nc)) continue;
   if (visited[nr][nc]) continue;
   if (floorArea[nr][nc] == '*') continue;
   if (floorArea[nr][nc] == '.') {
    que.push({ nr, nc });
    visited[nr][nc] = true;
   }
   else if (floorArea[nr][nc]=='$') {
    ans++;
    floorArea[nr][nc]='.';
    que.push({ nr, nc });
    visited[nr][nc] = true;
   }
   else if (islower(floorArea[nr][nc])) {
    if (!keys[floorArea[nr][nc] - 'a'])
    {
     keys[floorArea[nr][nc] - 'a'] = true;
     que.push({ nr, nc });
     fill(visited[0], visited[102], false);
    }
    else {
     que.push({ nr, nc });
     visited[nr][nc] = true;
    }
    
   }
   else if (isupper(floorArea[nr][nc])) {
    if (keys[floorArea[nr][nc] - 'A'])
    {
     que.push({ nr, nc });
     visited[nr][nc] = true;
    }
    
   }
  }
 }
}
int main()
{
 ios::sync_with_stdio(false);
 cin.tie(NULL);
 cout.tie(NULL);
 cin >> TC;
 while (TC-- > 0)
 {
  cin >> H >> W;
  fill(floorArea[0], floorArea[102], '.');
  string str;
  ans = 0;
  for (int h = 1; h <= H; h++)
  {
   cin >> str;
   memcpy(floorArea[h]+1, str.c_str(), str.length());
  }
  string keystr = "";
  fill(keys, keys+26, false);
  cin >> keystr;
  if (keystr.compare("0")!=0)
  {
   for (int i = 0; i < keystr.size(); i++)
   {
    keys[keystr[i] - 'a'] = true;
   }
  }
  findPaper();
  cout << ans << "\n";
 }
}