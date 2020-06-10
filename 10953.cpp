#include <iostream>
#include <string>

using namespace std;

int main()
{
	int n;

	cin >> n;

	for (int i = 0; i < n; i++)
	{
		int a, b;
		char s;

		cin >> a;
		cin >> s;
		cin >> b;

		cout << a + b << endl;
	}

	return 0;
}