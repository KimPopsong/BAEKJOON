#include <iostream>
#include <cmath>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int height;

	std::cin >> height;

	std::cout << pow(2, height) << "\n";

	return 0;
}
