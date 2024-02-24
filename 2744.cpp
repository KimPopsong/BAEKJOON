#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::string str;

	std::cin >> str;

	for (int i = 0; i < str.size(); i++)
	{
		if ('A' <= str[i] && str[i] <= 'Z')
		{
			str[i] += 32;
		}

		else
		{
			str[i] -= 32;
		}
	}

	std::cout << str;

	return 0;
}
