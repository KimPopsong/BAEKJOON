#include <stdio.h>
#include <string.h>
#include <Windows.h>

int main()
{
	int T, R;
	char S[21] = { 0 };

	scanf("%d", &T);

	for (int i = 0; i < T; i++)
	{
		scanf("%d", &R);

		scanf("%s", S);

		for (int j = 0; j < strlen(S); j++)
		{
			for (int k = 0; k < R; k++)
				printf("%c", S[j]);
		}

		printf("\n");
	}

	system("pause");
	return 0;
}