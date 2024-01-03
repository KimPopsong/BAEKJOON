#include <iostream>
#include <queue>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::queue<int> intQueue;
	int commandNum;

	std::cin >> commandNum;

	for (int i = 0; i < commandNum; i++)
	{
		std::string command;

		std::cin >> command;

		if (command == "push")
		{
			int temp;

			std::cin >> temp;

			intQueue.push(temp);
		}

		else if (command == "pop")
		{
			if (intQueue.empty())
			{
				std::cout << "-1" << "\n";
			}

			else
			{
				std::cout << intQueue.front() << "\n";
				intQueue.pop();
			}
		}

		else if (command == "size")
		{
			std::cout << intQueue.size() << "\n";
		}

		else if (command == "empty")
		{
			std::cout << intQueue.empty() << "\n";
		}

		else if (command == "front")
		{
			if (intQueue.empty())
			{
				std::cout << "-1" << "\n";
			}

			else
			{
				std::cout << intQueue.front() << "\n";
			}
		}

		else
		{
			if (intQueue.empty())
			{
				std::cout << "-1" << "\n";
			}

			else
			{
				std::cout << intQueue.back() << "\n";
			}
		}
	}

	return 0;
}
