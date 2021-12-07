#include <iostream>

int main()
{
	int n, m, location;

	std::cin >> n >> m >> location;

	std::cout << location / m << " " << location % m << "\n";

	return 0;
}
