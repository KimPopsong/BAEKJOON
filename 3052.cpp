#include <iostream>

using namespace std;

int main()
{
	int remain[42] = { 0 };
	int cnt = 0;

	for (int i = 0; i < 10; i++)
	{
		int x;
		cin >> x;
		x = x % 42;
		remain[x]++;
	}

	for (int i = 0; i < 42; i++)
		if (remain[i] != 0)
			cnt++;

	cout << cnt << endl;
	
	return 0;
}