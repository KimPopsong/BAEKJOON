#include <iostream>
#include <string.h>  // Given header

int callRecursionFunction = 0;

int recursion(const char* s, int l, int r)  // Given code
{
	callRecursionFunction += 1;

	if (l >= r)
	{
		return 1;
	}

	else if (s[l] != s[r])
	{
		return 0;
	}

	else
	{
		return recursion(s, l + 1, r - 1);
	}
}

int isPalindrome(const char* s)  // Given code
{
	return recursion(s, 0, strlen(s) - 1);
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int testCase;

	std::cin >> testCase;

	for (int i = 0; i < testCase; i++)
	{
		char test[1001];
		callRecursionFunction = 0;

		std::cin >> test;

		std::cout << isPalindrome(test) << " " << callRecursionFunction << "\n";
	}

	return 0;
}
