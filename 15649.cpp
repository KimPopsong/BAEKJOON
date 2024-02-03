#include <iostream>
#include <vector>

bool visited[9];
std::vector<int> answer;
int maxNum, combNum;

void Print()
{
	for (auto i : answer)
	{
		std::cout << i << " ";
	}
	std::cout << "\n";
}

void BackTracking(int depth)
{
	if (depth == combNum)
	{
		Print();
		
		return;
	}

	else
	{
		for (int i = 1; i <= maxNum; i++)
		{
			if (visited[i])
			{
				continue;
			}

			else
			{
				answer.push_back(i);
				visited[i] = true;

				BackTracking(depth + 1);

				visited[i] = false;
				answer.pop_back();
			}
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> maxNum >> combNum;

	BackTracking(0);

	return 0;
}
