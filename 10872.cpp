#include <iostream>

using namespace std;

int Fact(int n)
{
	if (n == 1)
		return n;

	else
		return Fact(n - 1) * n;
}

int main()
{
	int  n;

	cin >> n;

	if (n == 0)
	{
		n = 1;
	}

	cout << Fact(n) << endl;

	return 0;
}