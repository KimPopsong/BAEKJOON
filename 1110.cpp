#include <iostream>

using namespace std;

int main()
{
	int origin;
	int temp;
	int temp1, temp2;
	int cnt = 0;

	cin >> origin;

	if (origin < 10)
		origin *= 10;

	temp = origin;

	while (1)
	{
		temp1 = temp / 10;
		temp2 = temp % 10;

		temp1 += temp2;

		if (temp1 >= 10)
			temp1 %= 10;

		temp = (temp * 10) % 100;

		temp += temp1;

		cnt++;

		if (temp == origin)
		{
			cout << cnt << endl;
			break;
		}
	}

	return 0;
}