#include <iostream>

int main()
{
	std::cout << std::fixed;
	std::cout.precision(6);

	double gradeSum = 0, creditSum = 0;

	for (int i = 0; i < 20; i++)
	{
		std::string name, mark;
		double credit;

		std::cin >> name >> credit >> mark;

		creditSum += credit;

		if (mark == "A+")
		{
			gradeSum += 4.5 * credit;
		}

		else if (mark == "A0")
		{
			gradeSum += 4 * credit;
		}

		else if (mark == "B+")
		{
			gradeSum += 3.5 * credit;
		}

		else if (mark == "B0")
		{
			gradeSum += 3 * credit;
		}

		else if (mark == "C+")
		{
			gradeSum += 2.5 * credit;
		}

		else if (mark == "C0")
		{
			gradeSum += 2 * credit;
		}

		else if (mark == "D+")
		{
			gradeSum += 1.5 * credit;
		}

		else if (mark == "D0")
		{
			gradeSum += 1 * credit;
		}

		else if (mark == "P")
		{
			creditSum -= credit;
		}
	}

	std::cout << gradeSum / creditSum << std::endl;

	return 0;
}
