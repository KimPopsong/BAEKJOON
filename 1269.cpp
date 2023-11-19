#include <iostream>
#include <string>
#include <map>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int setANum, setBNum;
	int diff = 0;
	std::map<int, int> setA, setB;

	std::cin >> setANum >> setBNum;

	for (int i = 0; i < setANum; i++)
	{
		int temp;

		std::cin >> temp;

		setA.insert(std::make_pair(temp, 1));
	}

	for (int i = 0; i < setBNum; i++)
	{
		int temp;

		std::cin >> temp;

		setB.insert(std::make_pair(temp, temp));
	}

	for (auto iter = setB.begin(); iter != setB.end(); iter++)
	{
		if (setA.find(iter->first) == setA.end())
		{
			diff += 1; 
		}

		else
		{
			continue;
		}
	}

	for (auto iter = setA.begin(); iter != setA.end(); iter++)
	{
		if (setB.find(iter->first) == setB.end())
		{
			diff += 1;
		}

		else
		{
			continue; 
		}
	}

	std::cout << diff << "\n";

	return 0;
}
