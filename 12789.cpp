#include <iostream>
#include <stack>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::stack<int> waitingLine, tempSpace;
	int studentNum, numberTicket = 1;
	int tempLine[1001];

	std::cin >> studentNum;

	for (int i = 0; i < studentNum; i++)
	{
		std::cin >> tempLine[i];
	}

	for (int i = studentNum - 1; i >= 0; i--)
	{
		waitingLine.push(tempLine[i]);
	}

	while (numberTicket != studentNum)
	{
		if (!waitingLine.empty() && waitingLine.top() == numberTicket)
		{
			waitingLine.pop();
			numberTicket++;

			continue;
		}

		else if (!tempSpace.empty() && tempSpace.top() == numberTicket)
		{
			tempSpace.pop();
			numberTicket++;

			continue;
		}

		else if (waitingLine.empty())
		{
			std::cout << "Sad" << "\n";

			return 0;
		}

		else
		{
			tempSpace.push(waitingLine.top());
			waitingLine.pop();
		}
	}

	std::cout << "Nice" << "\n";

	return 0;
}
