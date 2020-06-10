#include <stdio.h>
#include <string.h>
#include <Windows.h>

int main()
{
	char T[100];

	scanf("%s", T);

	for (int i = 0; i < strlen(T);)
	{
		char k[11] = { 0 };

		for (int j = 0; j < 10; i++, j++)
		{
			k[j] = T[i];
		}

		printf("%s\n", k);
	}
	
	system("pause");
	return 0;
}