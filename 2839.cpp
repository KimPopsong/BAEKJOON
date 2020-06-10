#include <stdio.h>
#include <Windows.h>

int main()
{
	int N, M, T;//N = 소금의 양, M = 소금 - 5 * i, T = 5 * i
	int cnt = 100000;

	scanf("%d", &N);

	while (1)
	{
		for (int i = 0; i < (N + 5) / 5; i++)
		{
			for (int j = 0; j < (N + 3) / 3; j++)
			{
				T = (5 * i);

				M = N - T;

				if ((M - (3 * j) == 0))
				{
					int pre = 0;

					pre += i + j;

					if (pre < cnt)
						cnt = pre;
				}
			}
		}

		if (cnt != 100000)
		{
				printf("%d\n", cnt);

				system("pause");
				return 0;
		}

		printf("-1\n");

		system("pause");
		return 0;
	}

	system("pause");
	return 0;
}