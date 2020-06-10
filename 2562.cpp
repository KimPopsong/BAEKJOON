#include <iostream>

using namespace std;

int main()
{
	int num[10];
	int max = 0;
	int cnt;

	for (int i = 0; i < 9; i++)
	{
		cin >> num[i];

		if (num[i] > max)
		{
			max = num[i];
			cnt = i + 1;
		}
	}

	cout << max << endl;
	cout << cnt << endl;

	return 0;
}