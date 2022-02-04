#include <iostream>
#include <map>

std::map<std::string, std::string> password;

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int saved, find;

	std::cin >> saved >> find;

	for (int i = 0; i < saved; i++)
	{
		std::string domain, pass;

		std::cin >> domain >> pass;

		password.insert({ domain, pass });
	}

	for (int i = 0; i < find; i++)
	{
		std::string domainFind;

		std::cin >> domainFind;

		std::cout << password[domainFind] << "\n";
	}

	return 0;
}
