#include <iostream>

int main()
{
	bool student[31];

	for (int i = 0; i <= 30; i++)
	{
		student[i] = true;
	}

	for (int i = 0; i < 28; i++)
	{
		int n;

		std::cin >> n;

		student[n] = false;
	}

	for (int i = 1; i <= 30; i++)
	{
		if (student[i])
		{
			std::cout << i << std::endl;
		}
	}

	return 0;
}
