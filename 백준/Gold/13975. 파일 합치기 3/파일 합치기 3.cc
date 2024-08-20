#include <iostream>
#include <vector>
#include <queue>

using namespace std;

int TC, K;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    cout.tie(0);
    
	cin >> TC;

	while (TC-- > 0)
	{
		long long sum = 0L;
		//priority_queue<long, vector<long>, greater<long>> pq;
        priority_queue<long long> pq;
		int val = 0;

		cin >> K;

		for (int i = 0; i < K; i++)
		{
			cin >> val;
			pq.push(-val);
		}

		while (pq.size() > 1)
		{
			long long first = pq.top();
			pq.pop();
			long long second = pq.top();
			pq.pop();
			long long tmp = first + second;
			sum += tmp;
			pq.push(tmp);
		}

		cout << -sum << endl;
	}
}