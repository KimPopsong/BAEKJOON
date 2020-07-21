#include <iostream>

using namespace std;

void DrawFirst(int t)
{
	for (int i = 0 ; i < t; i++)
	{
		cout << "* ";
	}

	cout << endl;
}

void DrawSecond(int t)
{
	for (int i = 0; i < t; i++)
	{
		cout << " *";
	}

	cout << endl;
}

int main()
{
	int n;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		DrawFirst(n % 2 + n / 2);
		DrawSecond(n / 2);
	}

	return 0;
}