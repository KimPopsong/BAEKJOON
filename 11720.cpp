#include <stdio.h>
#include <Windows.h>

int main()
{
	int N, sum = 0;
	char M[100] = { 0 };

	scanf("%d", &N);
	scanf("%s", M);

	for (int i = 0; i < N; i++)
	{
		sum += M[i] - 48;
	}

	printf("%d\n", sum);

	system("pause");
	return 0;
}