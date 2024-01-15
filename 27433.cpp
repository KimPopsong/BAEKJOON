#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	long long number;

	std::cin >> number;

	if (number == 0)
	{
		std::cout << 1 << "\n";

		return 0;
	}

	else
	{
		for (int i = number - 1; i >= 2; i--)
		{
			number *= i;
		}
	}

	std::cout << number << "\n";

	return 0;
}
