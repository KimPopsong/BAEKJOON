#include <iostream>

using namespace std;

int main()
{
	int staticCost, dynamicCost, price;
	int time = 0;
	int gap;

	cin >> staticCost >> dynamicCost >> price;

	gap = price - dynamicCost;

	if (gap <= 0)
	{
		cout << -1 << endl;
	}

	else
	{
		time = staticCost / gap;
		cout << time + 1 << endl;
	}

	return 0;
}