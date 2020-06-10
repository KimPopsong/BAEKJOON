#include <iostream>

using namespace std;

int main()
{
	int sound[8];
	int checka = 0, checkd = 0;

	for (int i = 0; i < 8; i++)
		cin >> sound[i];

	for (int i = 0; i < 8; i++)
	{
		if (sound[i] == (i + 1))
			checka++;

		else if (sound[7 - i] == (i + 1))
			checkd++;
	}

	if (checka == 8)
		cout << "ascending" << endl;

	else if (checkd == 8)
		cout << "descending" << endl;

	else
		cout << "mixed" << endl;

	return 0;
}