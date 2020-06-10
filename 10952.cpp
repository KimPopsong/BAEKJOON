#include <stdio.h>
#include <windows.h>

int main()
{
	int a, b;
	
	while (1)
	{
		scanf("%d %d", &a, &b);

		if ((a + b) == 0)
			break;

		else
			printf("%d\n", a + b);
	}

	system("pause");
	return 0;
}