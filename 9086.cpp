#include <iostream>

int main()
{
	int testCase;

	std::cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		std::string word;

		std::cin >> word;

		std::cout << word[0] << word[word.length() - 1] << std::endl;;
	}

	return 0;
}
