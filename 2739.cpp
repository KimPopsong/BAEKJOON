#include <stdio.h>

int main()
{
	int i, j;
	scanf("%d", &i);

	for (j = 1; j <= 9; j++)
	{
		printf("%d * %d = %d\n", i, j, i*j);
	}

	return 0;
}
