#include <iostream>
#include <queue>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int subin, sister;
	bool visitied[100001] = { 0 };
	std::queue<int> bfs;

	std::cin >> subin >> sister;

	bfs.push(subin);
	for (int time = 0; !bfs.empty(); time++)
	{
		std::queue<int> temp;

		while (!bfs.empty())
		{
			if (bfs.front() == sister)
			{
				std::cout << time;

				return 0;
			}

			else
			{
				int t = bfs.front();
				bfs.pop();

				if (t - 1 >= 0 && !visitied[t - 1])
				{
					temp.push(t - 1);
					visitied[t - 1] = true;
				}

				if (t + 1 <= 100000 && !visitied[t + 1])
				{
					temp.push(t + 1);
					visitied[t + 1] = true;
				}

				if (t * 2 <= 100000 && !visitied[t * 2])
				{
					temp.push(t * 2);
					visitied[t * 2] = true;
				}
			}
		}
		bfs = temp;
	}

	return 0;
}
