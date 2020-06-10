#include <stdio.h>
#include <Windows.h>

int main()
{
	int cnt = 0, N;
	
	scanf("%d", &N);
	if (N == 1000)
	{
		printf("144\n");

		system("pause");
		return 0;
	}

	for (int i = 1; i <= N; i++)
	{
		if (i / 100 == 0) // 1 ~ 99
		{
			cnt++;
		}

		else // 100 ~ 999
		{
			int h = 0, t = 0, o = 0;

			h = i / 100; //100의 자리
			t = (i - 100 * h) / 10; //10의 자리
			o = (i - 100 * h - 10 * t);

			if ((h - t) == (t - o))
				cnt++;
		}
	}

	printf("%d\n", cnt);

	return 0;
}