#include <iostream>

int GetGCD(int numA, int numB)
{
	int r;

	while (numB != 0)
	{
		r = numA % numB;
		numA = numB;
		numB = r;
	}

	return numA;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int numerator1, numerator2, denominator1, denominator2;
	int gcd;

	std::cin >> numerator1 >> denominator1;
	std::cin >> numerator2 >> denominator2;

	gcd = GetGCD(numerator1 * denominator2 + numerator2 * denominator1, denominator1 * denominator2);

	std::cout << (numerator1 * denominator2 + numerator2 * denominator1) / gcd << " " << denominator1 * denominator2 / gcd;

	return 0;
}
