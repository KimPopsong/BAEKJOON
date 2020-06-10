#include <stdio.h>
#include <Windows.h>
#include <string.h>

int main()
{
	char sent[101];

	scanf("%s", sent);

	for (int j = 97; j < 123; j++)
	{
		int cnt = -1;

		for (int i = 0; i < strlen(sent); i++)
		{
			if ((char)j == sent[i])
			{
				cnt = i;
				break;
			}
		}

		printf("%d ", cnt);
	}

	system("pause");
	return 0;
}