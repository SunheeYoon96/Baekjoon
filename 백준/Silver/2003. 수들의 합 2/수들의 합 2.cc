#include <iostream>
#include <vector>

int main()
{
	int N, M, val, cnt;
	std::cin >> N >> M;

	std::vector<int> accumulateNums(N+1);
	accumulateNums[0] = 0;
	val = 0;
	cnt = 0;

	for (int i = 1; i <= N; i++)
	{
		std::cin >> val;
		accumulateNums[i] = accumulateNums[i - 1] + val;
	}

	for (int i = 0; i <= N; i++)
	{
		for (int j = 0; j <= i; j++)
		{
			if (accumulateNums[i] - accumulateNums[j] == M) cnt++;
		}
	}

	std::cout << cnt;
}