#include <iostream>

int w[21][21][21];

int CalcW(int n1, int n2, int n3)
{
	if (n1 <= 0 || n2 <= 0 || n3 <= 0)
	{
		return 1;
	}

	else if (n1 > 20 || n2 > 20 || n3 > 20)
	{
		return CalcW(20, 20, 20);
	}

	else if (w[n1][n2][n3] != 0)
	{
		return w[n1][n2][n3];
	}

	else if (n1 < n2 && n2 < n3)
	{
		w[n1][n2][n3] = CalcW(n1, n2, n3 - 1) + CalcW(n1, n2 - 1, n3 - 1) - CalcW(n1, n2 - 1, n3);
	}

	else
	{
		w[n1][n2][n3] = CalcW(n1 - 1, n2, n3) + CalcW(n1 - 1, n2 - 1, n3) + CalcW(n1 - 1, n2, n3 - 1) - CalcW(n1 - 1, n2 - 1, n3 - 1);
	}

	return w[n1][n2][n3];
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	while (true)
	{
		int num1, num2, num3;

		std::cin >> num1 >> num2 >> num3;

		if (num1 == -1 && num2 == -1 && num3 == -1)
		{
			break;
		}

		std::cout << "w(" << num1 << ", " << num2 << ", " << num3 << ") = " << CalcW(num1, num2, num3) << "\n";
	}
	
	return 0;
}
