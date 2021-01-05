#include <stdio.h>

int main()
{
	int i,j,k;

	scanf("%d %d %d", &i, &j, &k);

	if ((i >= j && j >= k) || (k >= j && j>= i))
		printf("%d\n", j);

	else if ((i >= k && k >= j) || (j >= k && k >= i))
		printf("%d\n", k);

	else
		printf("%d\n", i);

	return 0;
}	
