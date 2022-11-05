#include <iostream>
#include <queue>

std::priority_queue<int, std::vector<int>, std::greater<int>> positivePQ;
std::priority_queue<int> negaitivePQ;

void Print()
{
	if (positivePQ.size() == 0 && negaitivePQ.size() == 0)  // When no number exists.
	{
		std::cout << '0' << "\n";
	}

	else
	{
		if (positivePQ.empty())  // When no positive number exists.
		{
			std::cout << negaitivePQ.top() << "\n";

			negaitivePQ.pop();
		}

		else if (negaitivePQ.empty())  // When no negative number exists.
		{
			std::cout << positivePQ.top() << "\n";

			positivePQ.pop();
		}

		else  // When positive & negative exists.
		{
			if (std::abs(positivePQ.top()) < std::abs(negaitivePQ.top()))  // Compare absolute value
			{
				std::cout << positivePQ.top() << "\n";

				positivePQ.pop();
			}

			else
			{
				std::cout << negaitivePQ.top() << "\n";

				negaitivePQ.pop();
			}
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int calcTime;

	std::cin >> calcTime;

	for (int i = 0; i < calcTime; i++)
	{
		int n;

		std::cin >> n;

		if (n == 0)  // Print the lowest number of absolute values.
		{
			Print();
		}

		else  // Input number
		{
			if (n > 0)
			{
				positivePQ.push(n);
			}

			else
			{
				negaitivePQ.push(n);
			}
		}
	}

	return 0;
}
