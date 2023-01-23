#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int sumPrice, productNum;

	std::cin >> sumPrice;

	std::cin >> productNum;

	for (int i = 0; i < productNum; i++)
	{
		int a, b;

		std::cin >> a >> b;

		sumPrice -= a * b;
	}

	if (sumPrice)
	{
		std::cout << "No";
	}

	else
	{
		std::cout << "Yes";
	}

	std::cout << "\n";

	return 0;
}
