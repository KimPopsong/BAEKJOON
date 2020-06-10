#include <stdio.h>
#include <Windows.h>

int main()
{
	int ave, C, N;
	int score[1001] = { 0 };
	float per;

	scanf("%d", &C);

	for (int i = 0; i < C; i++)
	{
		float sum = 0, cnt = 0;

		scanf("%d", &N);

		for (int j = 0; j < N; j++)
		{
			scanf("%d", &score[j]);
			sum += score[j];
		}

		ave = sum / N;

		for (int j = 0; j < N; j++)
		{
			if (score[j] > ave)
				cnt++;
		}

		per = cnt * 100 / N;

		printf("%.3f%%\n", per);
	}

	system("pause");
	return 0;
}