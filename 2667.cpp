#include <iostream>
#include <stdio.h>  // To use scanf %1d
#include <vector>
#include <algorithm>

int size;
int count;

int apt[25][25] = { 0 };
bool check[25][25] = { false };

int dx[] = { 0, 0, 1, -1 };
int dy[] = { 1, -1, 0, 0 };

void dfs(int row, int col)
{
	if (row >= size || col >= size || row < 0 || col < 0)
	{
		return;
	}

	if (apt[row][col] == 1)
	{
		if (check[row][col] == false)
		{
			count += 1;

			check[row][col] = true;

			for (int i = 0; i < 4; i++)
			{
				dfs(row + dx[i], col + dy[i]);
			}
		}
	}
}

int main()
{
	int aptComplexCount = 0;
	std::vector<int> aptComplex;

	std::cin >> size;

	for (int row = 0; row < size; row++)
	{
		for (int col = 0; col < size; col++)
		{
			scanf("%1d", &apt[row][col]);
		}
	}

	for (int row = 0; row < size; row++)
	{
		for (int col = 0; col < size; col++)
		{
			if (apt[row][col] == 1)
			{
				if (check[row][col] == false)
				{
					count = 0;

					aptComplexCount++;

					dfs(row, col);

					aptComplex.push_back(count);
				}
			}
		}
	}

	std::sort(aptComplex.begin(), aptComplex.end());

	std::cout << aptComplexCount << std::endl;

	for (auto i = aptComplex.begin(); i != aptComplex.end(); i++)
	{
		std::cout << *i << std::endl;
	}

	return 0;
}
