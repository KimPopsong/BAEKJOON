#include <iostream>
#include <string>

using namespace std;

int main()
{
	string str;
	int word;
	int blank = 0;
	int removeBlank = 0;

	getline(cin, str);

	if (str[0] == 32)
	{
		removeBlank++;
	}

	if (str[str.length() - 1] == 32)
	{
		removeBlank++;
	}

	for (int i = 0; i < str.length(); i++)
	{
		if (str[i] == 32)
		{
			blank++;
		}
	}

	blank -= removeBlank;

	word = blank + 1;

	cout << word << endl;

	return 0;
}