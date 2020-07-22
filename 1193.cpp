#include <iostream>

using namespace std;

int main()
{
	int n;
	int sum = 0;
	int reverseFlag = 0;
	int numberator = 0, denominator; //분자, 분모

	cin >> n;

	for (int i = 1;; i++)
	{
		sum += i;

		if (reverseFlag == 0)
		{
			reverseFlag = 1;
		}

		else
		{
			reverseFlag = 0;
		}

		if (sum >= n)
		{
			sum -= i;
			denominator = i + 1;
			break;
		}
	}

	n -= sum;

	for (int i = 0; i < n; i++)
	{
		numberator++;
		denominator--;
	}

	if (reverseFlag == 0)
	{
		cout << numberator << "/" << denominator << endl;
	}

	else
	{
		cout << denominator << "/" << numberator << endl;
	}

	return 0;
}