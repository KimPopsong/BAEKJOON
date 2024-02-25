#include <iostream>
#include <algorithm>
#include <list>

int passwordLength, alphabetNum;
char password[20];
std::list<char> answer;

void Print()
{
	int vowel = 0, consonant = 0;

	for (auto i : answer)
	{
		if (i == 'a' || i == 'e' || i == 'i' || i == 'o' || i == 'u')  // Check if there is one vowel
		{
			vowel += 1;
		}

		else  // Check if there are two consonants
		{
			consonant += 1;
		}
	}

	if (vowel >= 1 && consonant >= 2)
	{
		for (auto i : answer)
		{
			std::cout << i;
		}
		std::cout << "\n";
	}
}

void BackTracking(int depth, int i)
{
	if (depth == passwordLength)
	{
		Print();

		return;
	}

	else
	{
		for (int j = i; j < alphabetNum; j++)
		{
			answer.push_back(password[j]);

			BackTracking(depth + 1, j + 1);

			answer.pop_back();
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::cin >> passwordLength >> alphabetNum;

	for (int i = 0; i < alphabetNum; i++)
	{
		std::cin >> password[i];
	}

	std::sort(password, password + alphabetNum);

	BackTracking(0, 0);

	return 0;
}
