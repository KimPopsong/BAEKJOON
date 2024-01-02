#include <iostream>
#include <cmath>

int primeNum[1000001];

void Erathosthenes()
{
	for (int i = 2; i <= sqrt(1000001); i++)
	{
		if (primeNum[i])
		{
			for (int j = 2; i * j <= 1000001; j++)
			{
				primeNum[i * j] = 0;
			}
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int testCase;

	std::cin >> testCase;

	for (int i = 2; i < 1000001; i++)
	{
		primeNum[i] = i;
	}

	Erathosthenes();

	for (int i = 0; i < testCase; i++)
	{
		int n;
		int goldbachPartition = 0;

		std::cin >> n;

		for (int i = 2; i <= n / 2; i++)
		{
			if (primeNum[i] + primeNum[n - i] == n)
			{
				goldbachPartition++;
			}
		}

		std::cout << goldbachPartition << "\n";
	}

	return 0;
}
