#include <stdio.h>

int main()
{
	int n, i, cnt = 0;
	scanf("%d", &n);
	
	for (i = 1; i <= n; i++)
		cnt += i;

	printf("%d\n", cnt);

	return 0;
}
