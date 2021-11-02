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

	if ((triangle[0] + triangle[1] + triangle[2]) != 180)
	{
		std::cout << "Error" << std::endl;
	}

	else if (triangle[0] == triangle[2])
	{
		std::cout << "Equilateral" << std::endl;
	}

	else if (triangle[0] == triangle[1] || triangle[1] == triangle[2])
	{
		std::cout << "Isosceles" << std::endl;
	}

	else
	{
		std::cout << "Scalene" << std::endl;
	}

	return 0;
}
