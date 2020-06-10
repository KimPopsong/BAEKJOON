#include <stdio.h>
#include <Windows.h>

int main()
{
	int E, S, M;
	int e = 1, s = 1, m = 1;
	int cnt = 1;

	scanf("%d %d %d", &E, &S, &M);

	while (e != E || s != S || m != M)
	{
		e++; s++; m++;
		cnt++;

		if (e > 15)
			e = 1;
		
		if (s > 28)
			s = 1;

		if (m > 19)
			m = 1;
	}

	printf("%d\n", cnt);

	system("pause");
	return 0;
}