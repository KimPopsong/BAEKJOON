#include <iostream>
#include <queue>

void Game();

int castle[17][16];
int tempCastle[17][16];
int row, col, range;
int killCount = 0;

void Game()  // 궁수가 공격하는 적은 거리가 range이하인 적 중에서 가장 가까운 적이고, 그러한 적이 여럿일 경우에는 가장 왼쪽에 있는 적을 공격한다. 같은 적이 여러 궁수에게 공격당할 수 있다.
{
	for (int archer1 = 0; archer1 <= col - 3; archer1++)
	{
		for (int archer2 = archer1 + 1; archer2 <= col - 2; archer2++)
		{
			for (int archer3 = archer2 + 1; archer3 <= col - 1; archer3++)
			{
				int tempKill = 0;  // Set game

				for (int i = 0; i < row; i++)
				{
					for (int j = 0; j < col; j++)
					{
						tempCastle[i][j] = castle[i][j];
					}
				}

				for (int turn = 0; turn <= row; turn++)
				{
					int archer[3] = { archer1, archer2, archer3 };
					std::queue<std::pair<int, int>> target;  // If find enemy, kill same time.

					for (int i = 0; i < 3; i++)
					{
						bool visited[16][16] = { false };
						std::queue<std::pair<int, int>> findEnemy;  // BFS

						findEnemy.push(std::make_pair(row - 1, archer[i]));

						while (!findEnemy.empty())  // Find enemy nearest fisrt.
						{
							int r = findEnemy.front().first;
							int c = findEnemy.front().second;

							findEnemy.pop();
							visited[r][c] = true;

							if (row - r + std::abs(archer[i] - c) > range)
							{
								break;
							}

							if (tempCastle[r][c] == 1)  // If enemy exists
							{
								target.push(std::make_pair(r, c));

								break;
							}

							else
							{
								if (c - 1 >= 0 && visited[r][c - 1] == false)
								{
									findEnemy.push(std::make_pair(r, c - 1));
								}

								if (r - 1 >= 0)
								{
									findEnemy.push(std::make_pair(r - 1, c));
								}

								if (c + 1 < col && visited[r][c + 1] == false)
								{
									findEnemy.push(std::make_pair(r, c + 1));
								}
							}
						}
					}

					while (!target.empty())  // Kill enemy.
					{
						if (tempCastle[target.front().first][target.front().second])
						{
							tempCastle[target.front().first][target.front().second] = false;
							tempKill += 1;
						}

						target.pop();
					}

					for (int i = row - 1; i >= turn; i--)  // 궁수의 공격이 끝나면, 적이 이동한다. 적은 아래로 한 칸 이동하며, 성이 있는 칸으로 이동한 경우에는 게임에서 제외된다
					{
						for (int j = 0; j < col; j++)
						{
							tempCastle[i][j] = tempCastle[i - 1][j];
						}
					}

					for (int j = 0; j < col; j++)
					{
						tempCastle[0][j] = 0;
					}
				}

				if (killCount < tempKill)
				{
					killCount = tempKill;
				}
			}
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> row >> col >> range;

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			std::cin >> castle[i][j];
		}
	}

	Game();

	std::cout << killCount;

	return 0;
}
