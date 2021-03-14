#include <iostream>

using namespace std;

int main()
{
	int sumGrade = 0;
	
	for (int i = 0; i < 5; i++)
	{
		int t;

		cin >> t;

		sumGrade += t;
	}

	cout << sumGrade << endl;

	return 0;
}