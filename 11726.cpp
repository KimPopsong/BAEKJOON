#include <stdio.h>
#include <windows.h>

int main()
{
	int fib[1001] = { 0 };
	int n;

	scanf("%d", &n);

	fib[0] = 1;
	fib[1] = 2;

	for (int i = 2; i <= n; i++)
	{
		fib[i] = (fib[i - 1] + fib[i - 2]) % 10007;
	}

	printf("%d\n", fib[n - 1]);

	system("pause");
	return 0;
}