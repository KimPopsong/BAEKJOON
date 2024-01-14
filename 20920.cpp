#include <iostream>

#include <list>
#include <map>

bool SortByLength(std::string str1, std::string str2)
{
	if (str1.length() > str2.length())
	{
		return true;
	}

	else
	{
		return false;
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int line, wordCriterion;
	int maxFrequency = 0, minFrequency = 100001;
	std::list<std::string> vocaList;
	std::map<std::string, int> vocaMap;

	std::cin >> line >> wordCriterion;

	for (int i = 0; i < line; i++)
	{
		std::string word;

		std::cin >> word;

		if (word.length() < wordCriterion)
		{
			continue;
		}

		else
		{
			if (vocaMap.count(word))
			{
				vocaMap[word] += 1;
			}

			else
			{
				vocaMap[word] = 1;
			}
		}
	}

	for (auto iter = vocaMap.begin(); iter != vocaMap.end(); iter++)
	{
		if (iter->second > maxFrequency)
		{
			maxFrequency = iter->second;
		}

		if (iter->second < minFrequency)
		{
			minFrequency = iter->second;
		}
	}

	for (int frequency = maxFrequency; frequency >= minFrequency; frequency--)
	{
		std::list<std::string> temp;

		for (auto iter = vocaMap.begin(); iter != vocaMap.end();)  // Sort by Frequency first.
		{
			if (iter->second == frequency)
			{
				temp.push_back(iter->first);

				vocaMap.erase(iter++->first);
			}

			else
			{
				iter++;
			}
		}

		temp.sort();  // Sort by lexicographical order 
		temp.sort(SortByLength);  // Sort by length

		for (auto iter : temp)
		{
			vocaList.push_back(iter);
		}
	}

	for (auto iter : vocaList)
	{
		std::cout << iter << "\n";
	}

	return 0;
}
