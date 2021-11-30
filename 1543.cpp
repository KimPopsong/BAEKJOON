#include <iostream>
#include <string>

std::string document;
std::string key;

bool Check(int index)
{
	bool flag = true;

	for (int i = 0; i < key.length(); i++)
	{
		if (document[index] == key[i])
		{
			index += 1;
		}

		else
		{
			flag = false;

			break;
		}
	}

	return flag;
}

int main()
{
	int keyLength;
	int count = 0;

	getline(std::cin, document);
	getline(std::cin, key);

	if (document.length() < key.length())
	{
		std::cout << count << std::endl;

		return 0;
	}

	for (int i = 0; i <= document.length() - key.length(); i++)
	{
		bool result = false;

		if (document[i] == key[0])
		{
			result = Check(i);
		}

		if (result)
		{
			count += 1;

			i += key.length() - 1;
		}
	}

	std::cout << count << std::endl;

	return 0;
}
