// 같은 알고리즘을 파이썬에서 코딩했지만
// 느려서 실패

#include <stdio.h>

int row, col;
int maxCount = 1;

char board[20][20] = { 0 };
bool passedAlphabet[27] = { false };

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void dfs(int count, int ii, int jj)
{
	maxCount = count > maxCount ? count : maxCount;

	for (int i = 0; i < 4; i++)
	{
		int x = ii + dx[i];
		int y = jj + dy[i];

		if ((0 <= x && x <= row - 1) && (0 <= y && y <= col - 1))
		{
			int asciiNumber = board[x][y] - 65;

			if (!(passedAlphabet[asciiNumber]))
			{
				passedAlphabet[asciiNumber] = true;

				dfs(count + 1, x, y);

				passedAlphabet[asciiNumber] = false;
			}
		}
	}
}

int main()
{
	scanf("%d %d", &row, &col);

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			scanf(" %c", &board[i][j]);
		}
	}

	passedAlphabet[board[0][0] - 65] = true;

	dfs(1, 0, 0);

	printf("%d\n", maxCount);

	return 0;
}
