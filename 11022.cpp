#include <iostream>

using namespace std;

int main()
{
	int T;
	int a[100], b[100];
	cin >> T;

	for (int i = 0; i < T; i++)
		cin >> a[i] >> b[i];

	for (int i = 0; i < T; i++)
		cout << "Case #" << i + 1 << ": " << a[i] << " + " << b[i] << " = " << a[i] + b[i] << endl;

	return 0;
}