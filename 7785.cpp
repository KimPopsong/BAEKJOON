#include <iostream>
#include <string>
#include <map>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int employeeNumber;
	std::map<std::string, int, std::greater<std::string>> commuteLog;

	std::cin >> employeeNumber;

	for (int i = 0; i < employeeNumber; i++)
	{
		std::string name, isCommute;

		std::cin >> name >> isCommute;

		if (isCommute == "enter")
		{
			if (commuteLog.find(name) != commuteLog.end())  // If already exists.
			{
				commuteLog[name] = 1;
			}

			commuteLog.insert(std::make_pair(name, 1));
		}

		else
		{
			commuteLog[name] = 0;
		}
	}

	for (auto iter = commuteLog.begin(); iter != commuteLog.end(); iter++)
	{
		if (iter->second == 0)  // If leave
		{
			continue;
		}

		else
		{
			std::cout << iter->first << "\n";
		}
	}

	return 0;
}
