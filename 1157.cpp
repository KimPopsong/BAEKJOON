#include <iostream>
#include <cstring>

using namespace std;

int main()
{
	string alphabet;
	int alpha[26] = { 0 };
	int maxNumber = -1;
	char maxAlpha = '?';

	cin >> alphabet;

	for (int i = 0; i < alphabet.length(); i++)
	{
		if (97 <= alphabet[i] && alphabet[i] <= 122)
		{
			alpha[alphabet[i] - 97]++;
		}

		if (65 <= alphabet[i] && alphabet[i] <= 90)
		{
			alpha[alphabet[i] - 65]++;
		}
	}

	for (int i = 0; i < 26; i++)
	{
		if (alpha[i] > maxNumber)
		{
			maxNumber = alpha[i];
			maxAlpha = i + 65;
		}

		else if (alpha[i] == maxNumber)
		{
			maxAlpha = '?';
		}
	}

	cout << maxAlpha << endl;

	return 0;
}