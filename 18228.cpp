#include <iostream>
#include <vector>

using namespace std;

int main()
{
	int ice;
	int num;
	int lmin = 1000000000;
	int rmin = 1000000000;

	vector<int> v;
	vector<int> left;
	vector<int> right;

	cin >> ice;

	for (int i = 0; i < ice; i++)
	{
		cin >> num;
		v.push_back(num);
	}

	int i;
	for (i = 0; v[i] != -1; i++)
	{
		left.push_back(v[i]);
	}

	i++;
	for (; i < v.size(); i++)
	{
		right.push_back(v[i]);
	}

	for (int i = 0; i < left.size(); i++)
	{
		if (left[i] < lmin)
			lmin = left[i];
	}

	for (int i = 0; i < right.size(); i++)
	{
		if (right[i] < rmin)
			rmin = right[i];
	}

	cout << rmin + lmin;

	return 0;
}
