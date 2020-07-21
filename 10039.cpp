#include <iostream>

using namespace std;

int main()
{
	int score[5];
	int ave = 0;

	for (int i = 0; i < 5; i++)
	{
		cin >> score[i];
		
		if (score[i] < 40)
			score[i] = 40;

		ave += score[i];
	}

	ave = ave / 5;

	cout << ave << endl;

	return 0;
}