#include <iostream>

using namespace std;

int TC, N, M;

int main()
{
	cin >> TC;

	while (TC-- > 0)
	{
		cin >> N >> M;
		for (int i = 0; i < M; i++)
		{
			int a, b;
			cin >> a >> b;
		}
		cout << N - 1 << endl;
	}
}