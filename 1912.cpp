#include <iostream>
#include <algorithm>

int numberList[100000];
int dp[100000];

int main()
{
	int number;

	scanf("%d", &number);

	for (int i = 0; i < number; i++)
	{
		scanf(" %d", &numberList[i]);
	}

	dp[0] = numberList[0];

	for (int i = 1; i < number; i++)
	{
		if (numberList[i] > dp[i - 1] + numberList[i])
		{
			dp[i] = numberList[i];
		}

		else
		{
			dp[i] = dp[i - 1] + numberList[i];
		}
	}

	std::cout << *std::max_element(dp, dp + number) << "\n";

	return 0;
}
