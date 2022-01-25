#include <iostream>
#include <queue>

int seaSize;
int sea[20][20] = { 0 };
int seaVisited[20][20] = { 0 };

int dx[4] = { 0, -1, 1, 0 };
int dy[4] = { -1, 0, 0, 1 };

int sharkSize = 2;  // Shark's Size.
int sharkSizeUpCount = 0;
int timeSpent = 0;
int targetDistance = 10000;

typedef struct Position
{
	int x;
	int y;
};

Position target, shark;

void Eat()
{
	sea[target.y][target.x] = 0;

	timeSpent += targetDistance;

	shark.x = target.x;
	shark.y = target.y;

	sharkSizeUpCount += 1;

	if (sharkSize == sharkSizeUpCount)
	{
		sharkSize += 1;
		sharkSizeUpCount = 0;
	}

	targetDistance = 10000;

	for (int i = 0; i < seaSize; i++)
	{
		for (int j = 0; j < seaSize; j++)
		{
			seaVisited[i][j] = -1;
		}
	}
}

void Search(int r, int c)  // Search fish which shark can eat.
{
	std::queue<Position> visitQueue;

	visitQueue.push({r, c});

	seaVisited[r][c] = 0;

	while (!visitQueue.empty())
	{
		Position pos = visitQueue.front();
		visitQueue.pop();

		r = pos.x;
		c = pos.y;

		for (int i = 0; i < 4; i++)
		{
			int rr = r + dy[i];
			int cc = c + dx[i];

			if (rr < 0 || rr >= seaSize || cc < 0 || cc >= seaSize)
			{
				continue;
			}

			if (seaVisited[rr][cc] >= 0 || sea[rr][cc] > sharkSize)  // If already visit or bigger fish.
			{
				continue;
			}

			if (sea[rr][cc] != 0 && sea[rr][cc] < sharkSize)  // Can eat.
			{
				if (targetDistance > seaVisited[r][c] + 1)
				{
					target.y = rr;
					target.x = cc;

					targetDistance = seaVisited[r][c] + 1;
				}

				else if (targetDistance == seaVisited[r][c] + 1)
				{
					if (target.y > rr)
					{
						target.y = rr;
						target.x = cc;
					}

					else if (target.y == rr)
					{
						if (target.x > cc)
						{
							target.x = cc;
						}
					}
				}

				else
				{
					return;
				}
			}

			else  // Can pass.
			{
				seaVisited[rr][cc] = seaVisited[r][c] + 1;
				visitQueue.push({ rr, cc });
			}
		}
	}
}

int main()
{
	scanf("%d", &seaSize);

	for (int i = 0; i < seaSize; i++)
	{
		for (int j = 0; j < seaSize; j++)
		{
			scanf(" %d", &sea[i][j]);

			if (sea[i][j] == 9)
			{
				sea[i][j] = 0;

				shark.x = j;
				shark.y = i;
			}

			seaVisited[i][j] = -1;
		}
	}

	while (true)
	{
		Search(shark.y, shark.x);

		if (targetDistance == 10000)
		{
			break;
		}

		Eat();
	}

	printf("%d\n", timeSpent);

	return 0;
}
