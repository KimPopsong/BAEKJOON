#include <iostream>

using namespace std;

int main()
{
	int exchange;
	int coinCount = 0;

	cin >> exchange;

	while (exchange > 0)
	{
		if (exchange % 5 == 0)
		{
			coinCount += exchange / 5;
			exchange = 0;

			break;
		}

		else
		{
			exchange -= 2;
			coinCount += 1;
		}
	}

	if (exchange != 0)
	{
		cout << "-1" << endl;
		
		return 0;
	}

	cout << coinCount << endl;

	return 0;
}
