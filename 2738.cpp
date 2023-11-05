#include <iostream>

int main()
{
	int col, row;
	int matrix1[101][101], matrix2[101][101];

	std::cin >> col >> row;

	for (int i = 0; i < col; i++)
	{
		for (int j = 0; j < row; j++)
		{
			std::cin >> matrix1[i][j];
		}
	}

	for (int i = 0; i < col; i++)
	{
		for (int j = 0; j < row; j++)
		{
			std::cin >> matrix2[i][j];
		}
	}

	for (int i = 0; i < col; i++)
	{
		for (int j = 0; j < row; j++)
		{
			std::cout << matrix1[i][j] + matrix2[i][j] << " ";
		}
		std::cout << "\n";
	}

	return 0;
}
