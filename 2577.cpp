#include <iostream>
#include <string>

using namespace std;

int main()
{
	int a, b, c;
	int res;
	int check[10] = { 0 };
	string result;

	cin >> a >> b >> c;

	res = a * b * c;

	result = to_string(res);

	for (int i = 0; i < result.size(); i++)
		check[result[i] - 48] += 1;

	for (int i = 0; i < 10; i++)
		cout << check[i] << endl;

	return 0;
}