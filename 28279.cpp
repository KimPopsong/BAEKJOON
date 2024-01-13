#include <iostream>
#include <deque>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::deque<int> intDeque;
	int commandNum;

	std::cin >> commandNum;

	for (int i = 0; i < commandNum; i++)
	{
		int command, temp;

		std::cin >> command;

		switch (command)
		{
		case 1:
			std::cin >> temp;
			intDeque.push_front(temp);

			break;

		case 2:
			std::cin >> temp;
			intDeque.push_back(temp);

			break;

		case 3:
			if (intDeque.empty())
			{
				std::cout << -1 << "\n";
			}

			else
			{
				std::cout << intDeque.front() << "\n";
				intDeque.pop_front();
			}

			break;

		case 4:
			if (intDeque.empty())
			{
				std::cout << -1 << "\n";
			}

			else
			{
				std::cout << intDeque.back() << "\n";
				intDeque.pop_back();
			}

			break;

		case 5:
			std::cout << intDeque.size() << "\n";

			break;

		case 6:
			std::cout << intDeque.empty() << "\n";

			break;

		case 7:
			if (intDeque.empty())
			{
				std::cout << -1 << "\n";
			}

			else
			{
				std::cout << intDeque.front() << "\n";
			}

			break;

		case 8:
			if (intDeque.empty())
			{
				std::cout << -1 << "\n";
			}

			else
			{
				std::cout << intDeque.back() << "\n";
			}

			break;

		default:
			break;
		}
	}

	return 0;
}
