#include <stdio.h>
#include <string.h>
#include <windows.h>

int main()
{
	char name[101] = { 0 };
	char st[100] = { 0 };
	int cnt = 0;

	scanf("%s", name);

	for (int i = 0; i < strlen(name); i++)
	{
		if (isupper(name[i]) == 1)
		{
			st[cnt] = name[i];
			cnt++;
		}
	}

	printf("%s\n", st);

	system("pause");
	return 0;
}