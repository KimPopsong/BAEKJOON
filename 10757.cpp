#include <iostream>
#include <string>

using namespace std;

int main()
{
	string A, B;
	string iA, iB;
	string temp;

	cin >> A;
	cin >> B;

	reverse(A.begin(), A.end());
	reverse(B.begin(), B.end());

	for(int i=0;;i++)
	{
		if (i >= A.size() && i >= B.size())
			break;

		else if (i >= A.size())
			temp += B[i];

		else if (i >= B.size())
			temp += A[i];

		else
			temp = ((A[i] - 48) + (B[i] - 48)); // 7 + 8�� ��� 15�� �Ǿ� 10�� �ڸ��� ���� �Ѿ
	}

	reverse(temp.begin(), temp.end());

	cout << temp << endl;

	system("pause");
	return 0;
}