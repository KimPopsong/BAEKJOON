#include <iostream>

using namespace std;

int main()
{
	int N, M, K; //사람, 반복횟수, 점원과의 거리

	int a[100][100] = { 0 };
	int human[100] = { 0 };
	int cnt[100] = { 0 };

	cin >> N >> M >> K;

	for (int i = 0; i < N; i++)
	{
		for (int j = 0; j < M; j++)
		{
			int n;
			cin >> n;

			a[i][j] = n;
		}
	}

	for (int j = 0; j < M; j++)
	{
		for (int i = 0; i < N; i++)
		{
			human[i] += a[i][j];
			cnt[i] += 1;
			if (human[i] >= K) 
			{
				cout << i + 1 << " " << cnt[i];
				return 0;
			}
		}
	}

	return 0;
}
