#include <iostream>

using namespace std;

int TC, N, L;
int minTime, maxTime, point;

int main()
{
	cin >> TC;

	for (int  tc = 0; tc < TC; tc++)
	{
		cin >> L >> N;
		minTime = 0;
		maxTime = 0;
		point = 0;

		for (int n = 0; n < N; n++)
		{
			cin >> point;
			int minDist = min(point, L - point);
			int maxDist = max(point, L - point);
			minTime = max(minTime, minDist);
			maxTime = max(maxTime, maxDist);
		}

		cout << minTime << " " << maxTime << endl;
	}
}