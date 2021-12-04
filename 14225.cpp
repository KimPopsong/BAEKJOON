#include <iostream>
#include <vector>
#include <algorithm>

bool number[2000000] = { false };  // 0 ~ 2000000 (100000 * 20). If false, can't come out as a sum.
int sequence[20] = { 0 };  // The number that forms the sequence.
int sequenceNumber;  // The number of members in a sequence.
std::vector<int> selectedNumber;  // Used for backtracking.

void BackTracking(int startIndex, int needToPick)
{
	if (needToPick == 0)  // Calculate sum in selectedNumber.
	{
		int sumNum = 0;

		for (int i = 0; i < selectedNumber.size(); i++)
		{
			sumNum += selectedNumber[i];
		}

		number[sumNum] = true;  // Set the sum's index true.
	}

	else
	{
		for (int i = startIndex; i < sequenceNumber; i++)
		{
			selectedNumber.push_back(sequence[i]);

			BackTracking(i + 1, needToPick - 1);

			selectedNumber.pop_back();
		}
	}
}

int main()
{
	number[0] = true;

	std::cin >> sequenceNumber;

	for (int i = 0; i < sequenceNumber; i++)
	{
		std::cin >> sequence[i];
	}

	std::sort(sequence, sequence + sequenceNumber);  // No need but added

	for (int haveToPick = 1; haveToPick <= sequenceNumber; haveToPick++)  // The number of members have to pick to make a combination.
	{
		BackTracking(0, haveToPick);
	}

	int i = 1;
	while (true)
	{
		if (!number[i])
		{
			std::cout << i << std::endl;

			break;
		}

		i += 1;
	}

	return 0;
}
