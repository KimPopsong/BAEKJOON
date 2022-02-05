#include <iostream>
#include <map>

int dp[50001] = { 0 };

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int number;

	std::cin >> number;

	for (int i = 1; i * i <= 50000; i++)
	{
		dp[i * i] = 1;
	}

	for (int i = 1; i <= number; i++)
	{
		if (dp[i] == 1)
		{
			continue;
		}

		else
		{
			int minTemp = 100;

			for (int j = 1; j * j <= i; j++)
			{
				if (dp[j * j] + dp[i - j * j] < minTemp)
				{
					minTemp = dp[j * j] + dp[i - j * j];
				}
			}

			dp[i] = minTemp;
		}
	}

	std::cout << dp[number] << "\n";

	return 0;
}
