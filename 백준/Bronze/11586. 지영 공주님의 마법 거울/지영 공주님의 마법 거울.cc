#include <iostream>
#include <vector>

using namespace std;

vector<vector<char>> showFace(vector<vector<char>> origin, int angryVal)
{
	int len = origin.size();
	vector<vector<char>> arr(len, vector<char>(len, 'A'));

	if (angryVal == 1) {
		return origin;
	}
	else if (angryVal == 2) {
		for (int r = 0; r < len; r++)
		{
			for (int c = 0; c < len; c++)
			{
				arr[r][c] = origin[r][len - 1 - c];
			}
		}
		return arr;
	}
	else {
		for (int r = 0; r < len; r++)
		{
			for (int c = 0; c < len; c++)
			{
				arr[r][c] = origin[len - 1 -r][c];
			}
		}
		return arr;
	}
}

int main()
{
	int N, angryLevel;
	cin >> N;

	vector<vector<char>> face(N, vector<char>(N, 'A'));
	vector<vector<char>> mirror(N, vector<char>(N, 'A'));

	for (int r = 0; r < N; r++)
	{
		for (int c = 0; c < N; c++)
		{
			cin >> face[r][c];
		}
	}

	cin >> angryLevel;
	
	mirror = showFace(face, angryLevel);

	for (int r = 0; r < N; r++)
	{
		for (int c = 0; c < N; c++)
		{
			cout << mirror[r][c];
		}
		cout << endl;
	}

}