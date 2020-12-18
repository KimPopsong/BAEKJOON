#include <iostream>

using namespace std;

int main()
{
	int yut[3][4] = { 0 };

	for (int i = 0; i < 3; i++)
	{
		for (int j = 0; j < 4; j++)
		{
			cin >> yut[i][j];
		}
	}

	for (int i = 0; i < 3; i++)
	{
		int count = 0;

		for (int j = 0; j < 4; j++)
		{
			if (!yut[i][j])
			{
				count += 1;
			}
		}

		switch (count)
		{
		case 1:
			cout << 'A' << endl;
			break;

		case 2:
			cout << 'B' << endl;
			break;

		case 3:
			cout << 'C' << endl;
			break;

		case 4:
			cout << 'D' << endl;
			break;

		default:
			cout << 'E' << endl;
			break;
		}
	}

	return 0;
}
