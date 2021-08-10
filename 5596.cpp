#include <iostream>

using namespace std;

int main()
{
	int minkuk = 0, manse = 0;

	for (int i = 0; i < 4; i++)
	{
		int temp = 0;

		cin >> temp;

		minkuk += temp;
	}

	for (int i = 0; i < 4; i++)
	{
		int temp = 0;

		cin >> temp;

		manse += temp;
	}

	int max = minkuk > manse ? minkuk : manse;

	cout << max;

	return 0;
}
