#include <iostream>
#include <vector>

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
			answer.push_back(i);

			BackTracking(depth + 1);

			answer.pop_back();
		}
	}

	return;
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
