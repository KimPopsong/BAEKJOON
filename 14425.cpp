#include <iostream>
#include <string>
#include <map>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int setNumber, checkNumber, count = 0;
	std::map<std::string, int> set;
	std::map<std::string, int>::iterator nod;

	std::cin >> setNumber >> checkNumber;

	for (int i = 0; i < setNumber; i++)
	{
		std::string temp;

		std::cin >> temp;

		set.insert(std::make_pair(temp, temp.length()));
	}

	for (int i = 0; i < checkNumber; i++)
	{
		std::string temp;

		std::cin >> temp;

		nod = set.find(temp);

		if (nod == set.end())
		{
			continue;
		}
		
		else
		{
			count += 1;
		}
	}

	std::cout << count << "\n";

	return 0;
}
