#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int balloonNumber, nod = 1, count = 0;
	int balloons[1002];

	std::cin >> balloonNumber;

	for (int i = 1; i <= balloonNumber; i++)
	{
		int temp;

		std::cin >> temp;
		balloons[i] = temp;
	}

	for (int i = 0; i < balloonNumber - 1; i++)
	{
		int next = balloons[nod];

		std::cout << nod << " ";

		balloons[nod] = 0;

		while(next != 0)
		{
			if (next > 0)
			{
				nod++;

				if (nod > balloonNumber)
				{
					nod = 1;
				}

				if (balloons[nod] == 0)
				{
					continue;
				}

				else
				{
					next--;
				}
			}

			else
			{
				nod--;

				if (nod <= 0)
				{
					nod = balloonNumber;
				}

				if (balloons[nod] == 0)
				{
					continue;
				}

				else
				{
					next++;
				}
			}
		}
	}

	for (int i = 1; i <= balloonNumber; i++)
	{
		if (balloons[i] != 0)
		{
			std::cout << i << "\n";

			break;
		}
	}

	return 0;
}
