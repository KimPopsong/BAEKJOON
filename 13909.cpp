#include <iostream>
#include <cmath>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int n;

	std::cin >> n;

	std::cout << int(sqrt(n)) << "\n";

	return 0;
}
