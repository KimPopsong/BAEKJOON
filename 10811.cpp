#include <iostream>

int main()
{
	int n, m;
	int basket[101];

	for (int i = 0; i < 101; i++)
	{
		basket[i] = i;
	}

	std::cin >> n >> m;

	for (int i = 0; i < m; i++)
	{
		int start, end;
		
		std::cin >> start >> end;

		for (int ii = 0; ii <= (end - start) / 2; ii++)
		{
			int temp = basket[end - ii];
			basket[end - ii] = basket[start + ii];
			basket[start + ii] = temp;
		}
	}

	for (int i = 1; i < n + 1; i++)
	{
		std::cout << basket[i] << " ";
	}

	return 0;
}
