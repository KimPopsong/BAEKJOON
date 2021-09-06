#include <iostream>
#include <string>

using namespace std;

int main()
{
	string str1;

	cin >> str1;

	int time;

	cin >> time;

	for (int i = 0; i < time; i++)
	{
		int first, second;

		string firstC, secondC;

		cin >> first >> second;

		firstC = str1[first];
		secondC = str1[second];

		str1.replace(first, 1, secondC);
		str1.replace(second, 1, firstC);
	}

	cout << str1;

	return 0;
}
