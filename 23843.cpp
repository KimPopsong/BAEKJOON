#include <iostream>
#include <cmath>

long long number;

void Print(long long ratio, long long termNumber)
{
	long long startNumber = number * (ratio - 1) / ((long long)(pow(ratio, termNumber) - 1));

	std::cout << termNumber << "\n";

	for (long long n = 1; n <= termNumber; n++)
	{
		std::cout << startNumber * pow(ratio, n - 1) << " ";  // a * (r ^ n - 1)
	}
	std::cout << "\n";
}

int main()
{
	std::cout << std::fixed;
	std::cout.precision(0);

	std::cin >> number;

	for (long long n = 3; n <= log(number + 1) / log(2); n++)
	{
		long long isDiv;

		for (long long r = 2; r < sqrt(number); r++)
		{
			isDiv = number * (r - 1) % ((long long)(pow(r, n) - 1));

			if (isDiv == 0)
			{
				Print(r, n);

				return 0;
			}

			else if ((pow(r, n) - 1) / (r - 1) > number)
			{
				break;
			}
		}
	}

	std::cout << "-1" << "\n";

	return 0;
}
