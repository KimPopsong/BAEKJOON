#include <iostream>
#include <algorithm>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int number[3] = { 0 };

	for (int i = 0; i < 3; i++)
	{
		std::cin >> number[i];
	}

	std::sort(number, number + 3);

	for (int i = 0; i < 3; i++)
	{
		std::cout << number[i];
		std::cout << " ";
	}

	return 0;
}
