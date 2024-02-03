#include <iostream>
#include <string>

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	std::string a, b;
	int c;

	std::cin >> a >> b >> c;

	std::cout << std::stoi(a) + std::stoi(b) - c << "\n";
	std::cout << std::stoi(a + b) - c << "\n";

	return 0;
}
