#include<iostream>

using namespace std;

int main()
{
	int first;
	string second;

	int a, b, c;

	cin >> first;
	cin >> second;

	a = first * ((int)second[2] - 48);
	b = first * ((int)second[1] - 48);
	c = first * ((int)second[0] - 48);

	cout << a << endl;
	cout << b << endl;
	cout << c << endl;
	cout << a + b * 10 + c * 100 << endl;

	system("pause");
	return 0;
}