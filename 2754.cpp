#include <iostream>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::string grade;

	std::cin >> grade;

	if (grade == "A+")
	{
		std::cout << "4.3";
	}

	else if (grade == "A0")
	{
		std::cout << "4.0";
	}

	else if (grade == "A-")
	{
		std::cout << "3.7";
	}

	else if (grade == "B+")
	{
		std::cout << "3.3";
	}

	else if (grade == "B0")
	{
		std::cout << "3.0";
	}

	else if (grade == "B-")
	{
		std::cout << "2.7";
	}

	else if (grade == "C+")
	{
		std::cout << "2.3";
	}

	else if (grade == "C0")
	{
		std::cout << "2.0";
	}

	else if (grade == "C-")
	{
		std::cout << "1.7";
	}

	else if (grade == "D+")
	{
		std::cout << "1.3";
	}

	else if (grade == "D0")
	{
		std::cout << "1.0";
	}

	else if (grade == "D-")
	{
		std::cout << "0.7";
	}

	else
	{
		std::cout << "0.0";
	}

	return 0;
}
