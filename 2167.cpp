#include <stdio.h>

int main()
{
	int row, col;
	int arr[300][300] = { 0 };
	int testCase = 0;

	scanf("%d %d", &row, &col);

	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			scanf(" %d", &arr[i][j]);
		}
	}

	scanf("%d", &testCase);

	for (int i = 0; i < testCase; i++)
	{
		int startY, startX, endY, endX;
		int sum = 0;

		scanf("%d %d %d %d", &startX, &startY, &endX, &endY);

		for (int j = startX - 1; j <= endX - 1; j++)
		{
			for (int k = startY - 1; k <= endY - 1; k++)
			{
				sum += arr[j][k];
			}
		}

		printf("%d\n", sum);
	}
	
	return 0;
}
