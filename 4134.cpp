#include <iostream>
#include <cmath>

bool IsPrime(long long isPrime)
{
	bool nod = true;

	for (long long i = 2; i <= sqrt(isPrime); i++)
	{
		if (isPrime % i == 0)
		{
			nod = false;

			break;
		}
	}

	return nod;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int testCase;

	std::cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		long long n;

		std::cin >> n;

		if (n == 0 || n == 1)
		{
			std::cout << 2 << "\n";

			continue;
		}

		for (long long i = n;; i++)
		{
			if (IsPrime(i))
			{
				std::cout << i << "\n";

				break;
			}
		}
	}

	return 0;
}
