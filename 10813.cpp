#include <iostream>

int main()
{
	int n, m;
	int basket[101];

	for (int i = 0; i < 101; i++)
	{
		basket[i] = i;
	}

	std::cin >> n >> m;

	for (int i = 0; i < m; i++)
	{
		int temp;
		int basket1, basket2;

		std::cin >> basket1 >> basket2;

		temp = basket[basket1];
		basket[basket1] = basket[basket2];
		basket[basket2] = temp;
	}

	for (int i = 1; i < n + 1; i++)
	{
		std::cout << basket[i] << " ";
	}

	return 0;
}
