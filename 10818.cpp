#include <iostream>

using namespace std;

int num[1000000];

int main()
{
	int N;
	int max = -2147483648;
	int min = 2147483647;

	cin >> N;

	for (int i = 0; i < N; i++)
	{
		cin >> num[i];

		if (num[i] > max)
			max = num[i];

		if (num[i] < min)
			min = num[i];
	}
	
	cout << min << " " << max << endl;
	return 0;
}