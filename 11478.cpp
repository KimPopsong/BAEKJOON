#include <iostream>
#include <string>
#include <map>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::string str;
	std::map<std::string, int> strSubset;

	std::cin >> str;

	int strLen = str.length();
	for (int i = 1; i <= strLen; i++)
	{
		for (int j = 0; j <= strLen - i; j++)
		{
			strSubset[str.substr(j, i)] = i;
		}
	}

	std::cout << strSubset.size() << "\n";

	return 0;
}
