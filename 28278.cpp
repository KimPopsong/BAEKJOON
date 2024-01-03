#include <iostream>

int stack[1000001];

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int commandNum, nod = 0;

	std::cin >> commandNum;

	for (int i = 0; i < commandNum; i++)
	{
		int command;

		std::cin >> command;

		switch (command)
		{
		case 1:
			int temp;

			std::cin >> temp;

			stack[nod] = temp;
			nod++;

			break;

		case 2:
			if (nod == 0)
			{
				std::cout << -1 << "\n";

				break;
			}

			else
			{
				nod--;

				std::cout << stack[nod] << "\n";
			}

			break;

		case 3:
			std::cout << nod << "\n";

			break;

		case 4:
			if (nod == 0)
			{
				std::cout << 1 << "\n";
			}

			else
			{
				std::cout << 0 << "\n";
			}

			break;

		case 5:
			if (nod == 0)
			{
				std::cout << -1 << "\n";
			}

			else
			{
				std::cout << stack[nod - 1] << "\n";
			}
		}
	}

	return 0;
}
