#include <stdio.h>
#include <Windows.h>

int main()
{
	int T;

	scanf("%d", &T);

	for (int i = 0; i < T; i++)
	{
		int n, m;

		scanf("%d %d", &n, &m);
		printf("%d\n", n + m);
	}

	system("pause");
	return 0;
}