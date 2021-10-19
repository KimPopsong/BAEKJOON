#include <iostream>

int sumNumbers[100001] = { 0 };

int main()
{
	/// Use for fast input & output
	std::ios_base::sync_with_stdio(0);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int numberCount, findCount;

	std::cin >> numberCount >> findCount;

	for (int i = 1; i <= numberCount; i++)
	{
		int temp;

		std::cin >> temp;

		sumNumbers[i] = sumNumbers[i - 1] + temp;
	}

	for (int i = 0; i < findCount; i++)
	{
		int start, end;

		std::cin >> start >> end;

		std::cout << sumNumbers[end] - sumNumbers[start - 1] << "\n";  // Using "\n" is faster than std::endl
	}

	return 0;
}
