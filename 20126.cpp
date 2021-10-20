#include <iostream>
#include <vector>
#include <algorithm>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::vector<std::pair<int, int>> exam;

	int anotherExamNumber, examTime, usableTime;
	int examStart = -1;

	std::cin >> anotherExamNumber >> examTime >> usableTime;

	for (int i = 0; i < anotherExamNumber; i++)
	{
		int start, end;

		std::cin >> start >> end;

		exam.push_back(std::pair<int, int>(start, end));
	}

	std::sort(exam.begin(), exam.end());

	if (exam[0].first >= examTime)  // When exam start 0
	{
		examStart = 0;
	}

	else if (exam[anotherExamNumber - 1].first + exam[anotherExamNumber - 1].second <= usableTime - examTime)  // When exam start last
	{
		examStart = exam[anotherExamNumber - 1].first + exam[anotherExamNumber - 1].second;
	}

	if (examStart != 0)  // When exam start between another exam
	{
		for (int i = 0; i < anotherExamNumber - 1; i++)
		{
			int leftTime = exam[i + 1].first - (exam[i].first + exam[i].second);

			if (leftTime >= examTime)
			{
				examStart = exam[i].first + exam[i].second;

				break;
			}
		}
	}

	std::cout << examStart << "\n";

	return 0;
}
