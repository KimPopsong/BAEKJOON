#include <iostream>
#include <algorithm>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int triangleSize;

	int dp[500] = { 0 };
	int line[500] = { 0 };

	std::cin >> triangleSize;

	for (int i = 0; i < triangleSize; i++)
	{
		int temp[500] = { 0 };

		for (int j = 0; j <= i; j++)
		{
			std::cin >> line[j];
		}

		temp[0] = line[0] + dp[0];

		for (int j = 1; j <= i; j++)
		{
			temp[j] = std::max(dp[j - 1] + line[j], dp[j] + line[j]);
		}

		for (int j = 0; j <= i; j++)
		{
			dp[j] = temp[j];
		}
	}

	std::cout <<*std::max_element(dp, dp + triangleSize) << "\n";

	return 0;
}
