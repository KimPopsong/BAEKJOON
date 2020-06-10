#include <stdio.h>
#include <windows.h>

int main()
{
	int A, B, C;

	scanf("%d", &A);
	scanf("%d", &B);
	scanf("%d", &C);

	printf("%d\n%d\n%d\n%d\n", (A + B) % C, (A%C + B % C) % C, (A*B) % C, (A%C * B%C) % C);

	system("pause");
	return 0;
}