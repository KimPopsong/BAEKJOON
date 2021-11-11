#include <iostream>

int main()
{
	int minScoreScience = 100;
	int minScoreLiterature = 100;
	int sumScore = 0;

	for (int i = 0; i < 4; i++)
	{
		int temp;

		std::cin >> temp;

		sumScore += temp;

		minScoreScience = minScoreScience > temp ? temp : minScoreScience;
	}

	for (int i = 0; i < 2; i++)
	{
		int temp;

		std::cin >> temp;

		sumScore += temp;

		minScoreLiterature = minScoreLiterature > temp ? temp : minScoreLiterature;
	}

	std::cout << sumScore - minScoreScience - minScoreLiterature << std::endl;

	return 0;
}
