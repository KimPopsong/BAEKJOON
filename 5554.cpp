#include <iostream>

using namespace std;

int main()
{
	int time[4] = { 0 };
	int timeSum = 0;
	int min = 0;

	for (int i = 0; i < 4; i++)
	{
		cin >> time[i];
		timeSum += time[i];
	}

	while (timeSum >= 60)
	{
		timeSum -= 60;
		min += 1;
	}

	cout << min << endl << timeSum << endl;

	return 0;
}
