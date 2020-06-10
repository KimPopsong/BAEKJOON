#include <stdio.h>
#include <Windows.h>

int main()
{
	int N, B = 0;
	float sum = 0, ave;
	int exam[1001] = { 0 };

	scanf("%d", &N);
	
	for (int i = 0; i < N; i++)
	{
		scanf("%d", &exam[i]);
		
		if (B < exam[i])
			B = exam[i];
	}

	for (int i = 0; i < N; i++)
	{
		sum += (float)exam[i]*100 / B;
	}

	ave = sum / N;

	printf("%f\n", ave);

	system("pause");
	return 0;
}