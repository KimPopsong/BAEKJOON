#include <iostream>

int fib[10000001];

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int n, tileZero, tileOne;

	std::cin >> n;
	
	fib[1] = 1;
	fib[2] = 2;

	for (int i = 3; i <= n; i++)
	{
		fib[i] = (fib[i - 1] + fib[i - 2]) % 15746;
	}

	std::cout << fib[n];

	return 0;
}
