#include <iostream>

int main()
{
	std::string word;
	int place;

	std::cin >> word >> place;

	std::cout << word[place - 1];

	return 0;
}
