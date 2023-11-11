#include <iostream>
#include <algorithm>

int main()
{
	int attendant, winner;
	int student[1001];

	std::cin >> attendant >> winner;

	for (int i = 0; i < attendant; i++)
	{
		std::cin >> student[i];
	}

	std::sort(student, student + attendant, std::greater<int>());

	std::cout << student[winner - 1] << std::endl;

	return 0;
}
