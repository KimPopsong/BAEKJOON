#include <iostream>
#include <cmath>

void CantorianSet(int head, int tail, int flag)
{
	if (flag == 0)
	{
		for (int i = head; i < tail; i++)
		{
			std::cout << " ";
		}

		return;
	}

	if (head + 1 == tail)
	{
		std::cout << "-";

		return;
	}

	CantorianSet(head, (head + tail) / 3, 1);
	CantorianSet((head + tail) / 3, (head + tail) / 3 * 2, 0);
	CantorianSet(head, (head + tail) / 3, 1);
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	while (true)
	{
		int n;

		std::cin >> n;

		if (std::cin.eof())
		{
			break;
		}

		else
		{
			CantorianSet(0, pow(3, n), 1);
			std::cout << "\n";
		}
	}

	return 0;
}
