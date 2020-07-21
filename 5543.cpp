#include <iostream>

using namespace std;

int main()
{
	int burger[3] = { 0 };
	int drink[2] = { 0 };
	int lowBurger = 2001;
	int lowDrink = 2001;

	for (int i = 0; i < 3; i++)
	{
		cin >> burger[i];

		if (burger[i] < lowBurger)
			lowBurger = burger[i];
	}

	for (int i = 0; i < 2; i++)
	{
		cin >> drink[i];
	
		if (drink[i] < lowDrink)
			lowDrink = drink[i];
	}

	cout << lowBurger + lowDrink - 50 << endl;

	return 0;
}