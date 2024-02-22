#include <iostream>

int f[100];
int callFib, callFibonacci;

int Fib(int n)
{
	if (n == 1 || n == 2)
	{
		callFib += 1;

		return 1;
	}

	else
	{
		return (Fib(n - 1) + Fib(n - 2));
	}
}

int Fibonacci(int n)
{
	f[1] = 1;
	f[2] = 1;

	for (int i = 3; i <= n; i++)
	{
		callFibonacci += 1;

		f[i] = f[i - 1] + f[i - 2];
	}

	return f[n];
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int n;

	std::cin >> n;

	Fib(n);
	Fibonacci(n);

	std::cout << callFib << " " << callFibonacci;
	
	return 0;
}
