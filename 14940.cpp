#include <iostream>
#include <queue>

int distanceMap[1001][1001];
bool visited[1001][1001];
int answer[1001][1001];

std::queue<std::pair<int, int>> bfs;
int startRow, startCol;
int mapRow, mapCol;

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> mapRow >> mapCol;

	for (int i = 0; i < mapRow; i++)
	{
		for (int j = 0; j < mapCol; j++)
		{
			std::cin >> distanceMap[i][j];

			if (distanceMap[i][j] == 2)
			{
				startRow = i;
				startCol = j;
			}
		}
	}

	bfs.push(std::make_pair(startRow, startCol));
	for (int distance = 0; !bfs.empty(); distance++)
	{
		std::queue<std::pair<int, int>> temp;

		while (!bfs.empty())
		{
			int r = bfs.front().first;
			int c = bfs.front().second;

			bfs.pop();

			visited[r][c] = true;
			answer[r][c] = distance;

			if (r - 1 >= 0 && distanceMap[r - 1][c] != 0 && visited[r - 1][c] != 1)  // Up
			{
				visited[r - 1][c] = true;
				temp.push(std::make_pair(r - 1, c));
			}

			if (c - 1 >= 0 && distanceMap[r][c - 1] != 0 && visited[r][c - 1] != 1)  // left
			{
				visited[r][c - 1] = true;
				temp.push(std::make_pair(r, c - 1));
			}

			if (r + 1 < mapRow && distanceMap[r + 1][c] != 0 && visited[r + 1][c] != 1)  // Down
			{
				visited[r + 1][c] = true;
				temp.push(std::make_pair(r + 1, c));
			}

			if (c + 1 < mapCol && distanceMap[r][c + 1] != 0 && visited[r][c + 1] != 1)  // Right
			{
				visited[r][c + 1] = true;
				temp.push(std::make_pair(r, c + 1));
			}
		}

		bfs = temp;
	}

	for (int i = 0; i < mapRow; i++)  // Land where can't go.
	{
		for (int j = 0; j < mapCol; j++)
		{
			if (visited[i][j] == false && distanceMap[i][j] != 0)
			{
				answer[i][j] = -1;
			}
		}
	}

	for (int i = 0; i < mapRow; i++)
	{
		for (int j = 0; j < mapCol; j++)
		{
			std::cout << answer[i][j] << " ";
		}
		std::cout << "\n";
	}

	return 0;
}
