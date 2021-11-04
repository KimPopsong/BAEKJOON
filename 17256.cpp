#include <iostream>

class Cake
{
private:
	int x, y, z;

public:
	void input();
	void set(int x, int y, int z);
	int getX();
	int getY();
	int getZ();
};

void Cake::input()
{
	std::cin >> x >> y >> z;
}

void Cake::set(int x, int y, int z)
{
	this->x = x;
	this->y = y;
	this->z = z;
}

int Cake::getX()
{
	return this->x;
}

int Cake::getY()
{
	return this->y;
}

int Cake::getZ()
{
	return this->z;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	Cake cakeA, cakeB, cakeC;

	cakeA.input();
	cakeC.input();

	cakeB.set(cakeC.getX() - cakeA.getZ(), cakeC.getY() / cakeA.getY(), cakeC.getZ() - cakeA.getX());

	std::cout << cakeB.getX() << " " << cakeB.getY() << " " << cakeB.getZ() << "\n";

	return 0;
}
