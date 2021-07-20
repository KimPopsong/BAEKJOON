#include <iostream>
#include <algorithm>

using namespace std;

int main()
{
	int hobbit[9] = { 0 };
	int sum = 0;

	for (int i = 0; i < 9; i++)
	{
		cin >> hobbit[i];

		sum += hobbit[i];
	}

	sort(hobbit, hobbit + 9);

	for (int i = 0; i < 8; i++)
	{
		for (int j = i + 1; j < 9; j++)
		{
			if (sum - hobbit[i] - hobbit[j] == 100)
			{
				for (int k = 0; k < 9; k++)
				{
					if (k == i || k == j)
					{
						continue;
					}

					cout << hobbit[k] << endl;
				}

				return 0;
			}
		}
	}

	return 0;
}
