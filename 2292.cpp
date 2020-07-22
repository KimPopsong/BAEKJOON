#include <iostream>

using namespace std;

int main()
{
	double dst;
	double start = 1;
	int count = 1;

	cin >> dst;

	for (int i = 1; start < dst; i++)
	{
		start += 6 * i;
		count++;
	}

	cout << count << endl;

	return 0;
}