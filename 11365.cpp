#include <stdio.h>
#include <string.h>
#include <Windows.h>

int main()
{
	while(1)
	{
		char enc[501] = { 0 };
		scanf(" %[^\n]", enc);

		if (enc[0] == 'E' && enc[1] == 'N' && enc[2] == 'D' && (strlen(enc) == 3))
			break;
		
		for (int i = strlen(enc) - 1; i >= 0; i--)
		{
			printf("%c", enc[i]);
		}
		printf("\n");
	} 
	
	system("pause");
	return 0;
}