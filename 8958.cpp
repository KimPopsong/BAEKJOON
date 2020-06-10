#include <iostream>
#include <string>

using namespace std;

int main()
{
	string s[1000];
	int result[1000] = { 0 };
	int n;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		cin >> s[i];

		int accumulate = 0;

		for (int j = 0; j < s[i].size(); j++)
		{
			if (s[i][j] == 'O')
			{
				accumulate++;
				result[i] += accumulate;
			}

			else
				accumulate = 0;
		}
	}

	for (int i = 0; i < n; i++)
		cout << result[i] << endl;

	return 0;
}