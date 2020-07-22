#include <iostream>

using namespace std;

int main()
{
	int n;
	int alpha[26] = { 0 };
	int groupWord = 0;
	int flag = 0;
	char rearAlpha;

	string str[100];

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> str[i];
	}

	for (int i = 0; i < n; i++)
	{
		flag = 0;
		rearAlpha = str[i][0];

		for (int j = 0; j < 26; j++)
		{
			alpha[j] = 0;
		}

		for (int j = 0; j < str[i].length(); j++)
		{
			if (rearAlpha == str[i][j])
			{
				alpha[str[i][j] - 97]++;
			}

			else
			{
				if (alpha[str[i][j] - 97] != 0)
				{
					flag = 1;
					break;
				}

				else
				{
					rearAlpha = str[i][j];
					alpha[str[i][j] - 97]++;
				}
			}

			rearAlpha = str[i][j];
		}

		if (flag == 0)
		{
			groupWord++;
		}
	}

	cout << groupWord << endl;

	return 0;
}