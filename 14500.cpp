#include <iostream>

int row, col;
int maxSum = 0;
int block[500][500] = { 0 };
bool visit[500][500] = { false };

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void DFS(int r, int c, int count, int sum)
{
	visit[r][c] = true;

	if (count >= 4)
	{
		maxSum = maxSum > sum ? maxSum : sum;

		return;
	}

	for (int i = 0; i < 4; i++)
	{
		int rr = r + dx[i];
		int cc = c + dy[i];

		if (rr < 0 || rr >= row || cc < 0 || cc >= col)
		{
			continue;
		}

		if (visit[rr][cc])
		{
			continue;
		}

		DFS(rr, cc, count + 1, sum + block[rr][cc]);

		visit[rr][cc] = false;
	}
}

void TetrominoT1()  // Tetromino T standing ㅜ
{
	for (int i = 0; i < row - 1; i++)
	{
		for (int j = 0; j < col - 2; j++)
		{
			int sum = 0;

			sum += block[i][j];
			sum += block[i][j + 1];
			sum += block[i][j + 2];
			sum += block[i + 1][j + 1];

			maxSum = maxSum > sum ? maxSum : sum;
		}
	}
}

void TetrominoT2()  // Tetromino T standing ㅗ
{
	for (int i = 1; i < row; i++)
	{
		for (int j = 0; j < col - 2; j++)
		{
			int sum = 0;

			sum += block[i][j];
			sum += block[i][j + 1];
			sum += block[i][j + 2];
			sum += block[i - 1][j + 1];

			maxSum = maxSum > sum ? maxSum : sum;
		}
	}
}

void TetrominoT3()  // Tetromino T standing ㅓ
{
	for (int i = 0; i < row - 2; i++)
	{
		for (int j = 1; j < col; j++)
		{
			int sum = 0;

			sum += block[i][j];
			sum += block[i + 1][j];
			sum += block[i + 2][j];
			sum += block[i + 1][j - 1];

			maxSum = maxSum > sum ? maxSum : sum;
		}
	}
}

void TetrominoT4()  // Tetromino T standing ㅏ
{
	for (int i = 0; i < row - 2; i++)
	{
		for (int j = 0; j < col - 1; j++)
		{
			int sum = 0;

			sum += block[i][j];
			sum += block[i + 1][j];
			sum += block[i + 2][j];
			sum += block[i + 1][j + 1];

			maxSum = maxSum > sum ? maxSum : sum;
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> row >> col;

	for (int r = 0; r < row; r++)
	{
		for (int c = 0; c < col; c++)
		{
			std::cin >> block[r][c];
		}
	}

	for (int r = 0; r < row; r++)
	{
		for (int c = 0; c < col; c++)
		{
			DFS(r, c, 1, block[r][c]);

			visit[r][c] = false;
		}
	}

	TetrominoT1();
	TetrominoT2();
	TetrominoT3();
	TetrominoT4();

	std::cout << maxSum << "\n";

	return 0;
}
