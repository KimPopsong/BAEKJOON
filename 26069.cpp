#include <iostream>
#include <set>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int meetTime;
	std::set<std::string> dancer;

	std::cin >> meetTime;

	dancer.insert("ChongChong");

	for (int i = 0; i < meetTime; i++)
	{
		std::string dancer1, dancer2;

		std::cin >> dancer1 >> dancer2;

		if (dancer.count(dancer1))
		{
			dancer.insert(dancer2);
		}

		else if (dancer.count(dancer2))
		{
			dancer.insert(dancer1);
		}
	}

	std::cout << dancer.size() << "\n";
		
	return 0;
}
