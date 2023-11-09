#include <iostream>
#include <algorithm>

int main()
{
	int triangle[3];

	for (int i = 0; i < 3; i++)
	{
		std::cin >> triangle[i];
	}
	
	std::sort(triangle, triangle + 3);

	if (triangle[0] + triangle[1] <= triangle[2])
	{
		std::cout << (triangle[0] + triangle[1]) * 2 - 1;
	}

	else
	{
		std::cout << triangle[0] + triangle[1] + triangle[2];
	}

	std::cout << "\n";

	return 0;
}
