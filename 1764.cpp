#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
	int neverHeard, neverSeen;
	int neverHeardSeen = 0;

	std::vector<std::string> neverHeardVector;
	std::vector<std::string> neverHeardSeenVector;

	std::cin >> neverHeard >> neverSeen;

	for (int i = 0; i < neverHeard; i++)
	{
		std::string temp;

		std::cin >> temp;

		neverHeardVector.push_back(temp);
	}

	std::sort(neverHeardVector.begin(), neverHeardVector.end());

	for (int i = 0; i < neverSeen; i++)
	{
		std::string temp;

		std::cin >> temp;

		if (std::binary_search(neverHeardVector.begin(), neverHeardVector.end(), temp))
		{
			neverHeardSeen += 1;
			neverHeardSeenVector.push_back(temp);
		}
	}

	std::sort(neverHeardSeenVector.begin(), neverHeardSeenVector.end());

	std::cout << neverHeardSeen << std::endl;
	for (auto i = neverHeardSeenVector.begin(); i != neverHeardSeenVector.end(); i++)
	{
		std::cout << *i << std::endl;
	}

	return 0;
}
