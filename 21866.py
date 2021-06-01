#include <stdio.h>

int main()
{
	int score[9] = { 0 };
	int sumScore = 0;

	for (int i = 0; i < 9; i++) 
	{
		int temp;

		scanf(" %d", &temp);

		sumScore += temp;
		score[i] = temp;
	}

	if (score[0] > 100 || score[1] > 100 || score[2] > 200 || score[3] > 200 || score[4] > 300 || score[5] > 300 || score[6] > 400 || score[7] > 400 || score[8] > 500)
	{
		printf("hacker\n");
	}

	else if (sumScore >= 100)
	{
		printf("draw\n");
	}

	else
	{
		printf("none\n");
	}

	return 0;
}
