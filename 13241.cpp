#include <iostream>
#include <string>
#include <map>

long long int GetGCD(long long int numA, long long int numB)
{
	long long int r;

	while (numB != 0)
	{
		r = numA % numB;
		numA = numB;
		numB = r;
	}

	return numA;
}

long long int GetLCM(long long int numA, long long int numB, long long int GCD)
{
	return numA * numB / GCD;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	long long int numA, numB, GCD = 1;

	std::cin >> numA >> numB;

	if (numA < numB)  // numA is bigger number.
	{
		long long int temp = numB;
		numB = numA;
		numA = temp;
	}

	GCD = GetGCD(numA, numB);

	std::cout << GetLCM(numA, numB, GCD) << "\n";

	return 0;
}
