#include <iostream>

int InputNum()
{
	int num;

	std::cin >> num;

	return num;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	bool arr[21] = { false };
	int calcNum;

	std::cin >> calcNum;

	for (int i = 0; i < calcNum; i++)
	{
		std::string command;

		std::cin >> command;

		if (command == "add")
		{
			arr[InputNum()] = true;
		}

		else if (command == "remove")
		{
			arr[InputNum()] = false;
		}

		else if (command == "check")
		{
			if (arr[InputNum()])
			{
				std::cout << "1" << "\n";
			}

			else
			{
				std::cout << "0" << "\n";
			}
		}

		else if (command == "toggle")
		{
			int x;

			x = InputNum();

			arr[x] = !arr[x];
		}

		else if (command == "all")
		{
			for (int j = 0; j <= 20; j++)
			{
				arr[j] = true;
			}
		}

		else
		{
			for (int j = 0; j <= 20; j++)
			{
				arr[j] = false;
			}
		}
	}

	return 0;
}
