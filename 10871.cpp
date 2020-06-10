#include <stdio.h>
#include <Windows.h>

int main()
{
	int N, X, A;
	
	scanf("%d %d", &N, &X);

	for (int i = 0; i < N; i++)
	{
		scanf("%d", &A);

		if (A < X)
			printf("%d ", A);
	}

	printf("\n");

	system("pause");
	return 0;
}