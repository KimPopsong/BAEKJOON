#include <iostream>

int main()
{
	int number;
	int line = 2;

	std::cin >> number;

	for (int i = 0; i < number; i++)
	{
		line += line - 1;
	}
	
	std::cout << line * line << std::endl;

	return 0;
}
