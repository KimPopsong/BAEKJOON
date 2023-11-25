#include <iostream>

int GetGCD(int numA, int numB)
{
	int r;

	while (numB != 0)
	{
		r = numA % numB;
		numA = numB;
		numB = r;
	}

	return numA;
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int treeNum, gcd, treeNeed = 0;
	int tree[100001];

	std::cin >> treeNum;

	for (int i = 0; i < treeNum; i++)
	{
		std::cin >> tree[i];
	}

	gcd = tree[1] - tree[0];

	for (int i = 2; i < treeNum; i++)
	{
		gcd = GetGCD(gcd, tree[i] - tree[i - 1]);
	}
	
	std::cout << (tree[treeNum - 1] - tree[0]) / gcd + 1 - treeNum << "\n";

	return 0;
}
