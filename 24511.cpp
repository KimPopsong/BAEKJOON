#include <iostream>
#include <queue>
#include <stack>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int queueStackSize, sequenceSize;
	std::queue<int> queueLocation, queueSequence;
	std::stack<int> stackTemp;

	std::cin >> queueStackSize;

	for (int i = 0; i < queueStackSize; i++)
	{
		int temp;

		std::cin >> temp;

		if (temp)
		{
			continue;
		}

		else
		{
			queueLocation.push(i);
		}
	}

	for (int i = 0; i < queueStackSize; i++)
	{
		int temp;

		std::cin >> temp;

		if (!queueLocation.empty() && i == queueLocation.front())
		{
			stackTemp.push(temp);
			queueLocation.pop();
		}
	}

	while (!stackTemp.empty())
	{
		queueSequence.push(stackTemp.top());
		stackTemp.pop();
	}

	std::cin >> sequenceSize;

	for (int i = 0; i < sequenceSize; i++)
	{
		int temp;

		std::cin >> temp;

		queueSequence.push(temp);

		std::cout << queueSequence.front() << " ";
		queueSequence.pop();
	}

	return 0;
}
