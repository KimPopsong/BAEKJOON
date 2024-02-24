#include <iostream>
#include <deque>

int lottoNum;
int lotto[15];
std::deque<int> answer;

void Print()
{
	for (auto i : answer)
	{
		std::cout << i << " ";
	}
	std::cout << "\n";
}

void BackTracking(int depth, int i)
{
	if (depth == 6)
	{
		Print();

		return;
	}

	else
	{
		for (int j = i; j < lottoNum; j++)
		{
			answer.push_back(lotto[j]);

			BackTracking(depth + 1, j + 1);

			answer.pop_back();
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	while (true)
	{
		std::cin >> lottoNum;

		if (lottoNum == 0)
		{
			break;
		}

		for (int i = 0; i < lottoNum; i++)
		{
			std::cin >> lotto[i];
		}

		BackTracking(0, 0);

		std::cout << "\n";
	}

	return 0;
}
