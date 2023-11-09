#include <iostream>
#include <cmath>
#include <list>
#include <algorithm>
#include <numeric>

int main()
{
	for (;;)
	{
		int number;
		long long sumDiv = 1;
		std::list<int> divisor;

		std::cin >> number;

		if (number == -1)
		{
			break;
		}

		for (int i = 2; i <= std::sqrt(number); i++)
		{
			if (number % i == 0)
			{
				divisor.push_back(i);
				divisor.push_back(number / i);
			}
		}

		if (divisor.empty())
		{
			std::cout << number << " is NOT perfect." << std::endl;
			continue;
		}

		if (number == divisor.back() * divisor.back())  // If it's square
		{
			divisor.pop_back();  // Delete last element
		}

		divisor.sort();  // Sort divisor

		for (auto i = divisor.begin(); i != divisor.end(); i++)
		{
			sumDiv += *i;
		}

		if (number == sumDiv)
		{
			std::cout << number << " = 1";
			for (std::list<int>::iterator i = divisor.begin(); i != divisor.end(); i++)
			{
				std::cout << " + " << *i;
			}
			std::cout << "\n";
		}

		else
		{
			std::cout << number << " is NOT perfect." << std::endl;
		}
	}

	return 0;
}
