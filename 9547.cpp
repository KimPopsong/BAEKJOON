#include <iostream>

int preference[100][100] = { 0 };  // To avoid C6262. Voter's preference

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int testCase;

	std::cin >> testCase;

	for (int t = 0; t < testCase; t++)
	{
		int candidatesNumber, votersNumber;
		int candidates[100] = { 0 };  // The number of votes by the candidates
		int candidate1Index, candidate2Index, winner = 0;  // Use when elect second time. Winner's number

		std::cin >> candidatesNumber >> votersNumber;

		for (int i = 0; i < votersNumber; i++)
		{
			for (int j = 0; j < candidatesNumber; j++)
			{
				std::cin >> preference[i][j];
			}
		}

		int electTime = 0;  // Check how many elections done
		while (electTime <= 2)
		{
			electTime += 1;

			if (electTime == 1)  // When elect first time
			{
				for (int i = 0; i < votersNumber; i++)
				{
					candidates[preference[i][0]] += 1;  // Sum the number of votes by the candidates.
				}

				for (int i = 1; i <= candidatesNumber; i++)
				{
					if (candidates[i] > votersNumber / 2)  // Check if the majority is over
					{
						winner = i;

						break;
					}
				}

				if (winner)  // If winner exists
				{
					break;
				}

				else  // Choose the two people who get the most votes
				{
					int temp = candidates[0];

					candidate1Index = 0;
					for (int i = 1; i <= candidatesNumber; i++)
					{
						if (temp < candidates[i])
						{
							temp = candidates[i];

							candidate1Index = i;
						}
					}

					temp = candidates[0];
					candidate2Index = 0;
					for (int i = 1; i <= candidatesNumber; i++)
					{
						if (temp < candidates[i])
						{
							if (i == candidate1Index)
							{
								continue;
							}

							temp = candidates[i];

							candidate2Index = i;
						}
					}
				}
			}

			else  // Elect second time
			{
				int cand1Votes = 0, cand2Votes = 0;

				for (int v = 0; v < votersNumber; v++)
				{
					for (int c = 0; c < candidatesNumber; c++)
					{
						if (preference[v][c] == candidate1Index)
						{
							cand1Votes += 1;

							break;
						}

						else if (preference[v][c] == candidate2Index)
						{
							cand2Votes += 1;

							break;
						}
					}
				}

				winner = cand1Votes > cand2Votes ? candidate1Index : candidate2Index;

				break;
			}
		}

		std::cout << winner << " " << electTime << "\n";
	}

	return 0;
}
