#include <iostream>

using namespace std;

int main()
{
	int n;

	cin >> n;

	for (int i = 0; i < n - 1; i++)
	{
		for (int j = 0; j < i; j++)
		{
			cout << " ";
		}

		for (int j = 0; j < 2 * n - 1 - 2 * i; j++)
		{
			cout << "*";
		}

		cout << endl;
	}

	for (int i = 0; i < n - 1; i++)
	{
		cout << " ";
	}

	cout << "*" << endl;

	for (int i = n - 1; i > 0; i--)
	{
		for (int j = i - 1; j > 0; j--)
		{
			cout << " ";
		}

		for (int j = 2 * n - 2 * i; j >= 0; j--)
		{
			cout << "*";
		}

		cout << endl;
	}	

	return 0;
}