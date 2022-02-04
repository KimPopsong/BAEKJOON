#include <iostream>
#include <queue>

std::priority_queue<int, std::vector<int>, std::greater<int>> numbers;

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int inputNumber;

	std::cin >> inputNumber;

	for (int i = 0; i < inputNumber; i++)
	{
		int temp;

		std::cin >> temp;

		if (temp == 0)
		{
			if (numbers.empty())  // When empty, print '0'.
			{
				std::cout << "0" << "\n";
			}

			else  // Print smallest number.
			{
				std::cout << numbers.top() << "\n";

				numbers.pop();
			}
		}

		else  // Add in numbers.
		{
			numbers.push(temp);
		}
	}

	return 0;
}
