#include <stdio.h>
#include <Windows.h>

int main()
{
	int M, N, is = 0, js = 0, Rcnt = 2147483647;
	char chess[51][51] = { 1 }, chs[9][9] = { 0 };

	scanf("%d %d", &M , &N);

	for (int i = 0; i < M; i++)
		for (int j = 0; j < N; j++)
			scanf(" %c", &chess[i][j]);

	for (is = 0; is + 8 <= M; is++)
	{
		for(js = 0; js + 8 <= N; js++)
		{
			int cnt = 0;

			for (int i = 0; i < 8; i++)
				for (int j = 0; j < 8; j++)
					chs[i][j] = chess[is + i][js + j];

			for (int i = 0; i < 8; i++)
			{
				for (int j = 0; j < 8; j++)
				{
					if (chs[i][j] == chs[i][j + 1])
					{
						if (chs[i][j + 1] == 'W')
						{
							chs[i][j + 1] = 'B';
							cnt++;
						}

						else
						{
							chs[i][j + 1] = 'W';
							cnt++;
						}
					}
				}

				if (chs[i][0] == chs[i + 1][0])
				{
					if (chs[i + 1][0] == 'W')
					{
						chs[i + 1][0] = 'B';
						cnt++;
					}

					else
					{
						chs[i + 1][0] = 'W';
						cnt++;
					}
				}
			}

			if (cnt > 32)
				cnt = 64 - cnt;

			if (Rcnt > cnt)
				Rcnt = cnt;
		}
	}
	
	printf("%d\n", Rcnt);

	return 0;
}