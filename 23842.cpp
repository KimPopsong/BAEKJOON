#include <iostream>

int main()
{
	int match[] = { 6,2,5,5,4,5,6,3,7,6 };
	int matchstickNumber;

	std::cin >> matchstickNumber;

	matchstickNumber -= 4;  // +, =

	for (int firstNumber = 0; firstNumber <= 99; firstNumber++)
	{
		for (int secondNumber = 0; secondNumber <= 99; secondNumber++)
		{
			int first = 0, second = 0, sum = 0;

			if (firstNumber < 10)
			{
				first += match[firstNumber];
				first += match[0];
			}

			else
			{
				first += match[firstNumber / 10];
				first += match[firstNumber % 10];
			}

			if (secondNumber < 10)
			{
				second += match[secondNumber];
				second += match[0];
			}

			else
			{
				second += match[secondNumber / 10];
				second += match[secondNumber % 10];
			}

			if (firstNumber + secondNumber < 10)
			{
				sum += match[firstNumber + secondNumber];
				sum += match[0];
			}

			else
			{
				sum += match[(firstNumber + secondNumber) / 10];
				sum += match[(firstNumber + secondNumber) % 10];
			}

			if (first + second + sum == matchstickNumber && (firstNumber + secondNumber) < 100)
			{
				if (firstNumber < 10)
				{
					std::cout << "0";
				}

				std::cout << firstNumber << "+";
				
				if (secondNumber < 10)
				{
					std::cout << "0";
				}

				std::cout << secondNumber << "=";
				
				if (firstNumber + secondNumber < 10)
				{
					std::cout << "0";
				}

				std::cout << firstNumber + secondNumber << "\n";

				return 0;
			}
		}
	}

	std::cout << "impossible" << "\n";

	return 0;
}
