#include <iostream>
#include <set>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int line, emoticon = 0, enter = 0;
	std::set<std::string> chat;

	std::cin >> line;

	for (int i = 0; i < line; i++)
	{
		std::string str;

		std::cin >> str;

		chat.insert(str);

		if (str == "ENTER")
		{
			enter += 1;

			emoticon += chat.size();

			chat.clear();
		}
	}

	emoticon += chat.size();

	std::cout << emoticon - enter << "\n";
		
	return 0;
}
