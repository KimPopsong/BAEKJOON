#include <iostream>

int main()
{
	int stairNumber;
	int stair[301] = { 0 }, dpStair[301] = { 0 };

	std::cin >> stairNumber;

	for (auto i = 1; i <= stairNumber; i++)  // Stair's index start at 1. Not 0
	{
		std::cin >> stair[i];
	}

	dpStair[1] = stair[1];
	dpStair[2] = dpStair[1] + stair[2];

	for (auto stairNow = 3; stairNow <= stairNumber; stairNow++)
	{
		auto stairUnderTwo = dpStair[stairNow - 2] + stair[stairNow];
		auto stairUnderOne = dpStair[stairNow - 3] + stair[stairNow - 1] + stair[stairNow];

		dpStair[stairNow] = stairUnderTwo >= stairUnderOne ? stairUnderTwo : stairUnderOne;
	}

	std::cout << dpStair[stairNumber] << "\n";

	return 0;
}
