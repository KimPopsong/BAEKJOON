#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int sqSize, max = 0;
	int sequence[1001], dp[1001];

	std::cin >> sqSize;

	for (int i = 0; i < sqSize; i++)
	{
		std::cin >> sequence[i];
	}

	dp[0] = 1;

	for (int i = 1; i < sqSize; i++)
	{
		int n = sequence[i];
		int maxDP = 0;

		dp[i] = 1;

		for (int j = i - 1; j >= 0; j--)
		{
			if (sequence[j] < n)
			{
				maxDP = dp[j] > maxDP ? dp[j] : maxDP;
			}
		}

		dp[i] += maxDP;
	}

	for (int i = 0; i < sqSize; i++)
	{
		if (dp[i] > max)
		{
			max = dp[i];
		}
	}

	std::cout << max << "\n";

	return 0;
}
