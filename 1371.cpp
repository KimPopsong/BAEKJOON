#include <iostream>
#include <string>
#include <map>

int main()
{
    int maxCount = 0;
    std::string s, answer;
    std::map<char, int> characterMap;

    while (std::getline(std::cin, s))
    {
        for (char c : s)
        {
            if (c == ' ')
            {
                continue;
            }

            characterMap[c] += 1;
        }
    }

    for (const auto &pair : characterMap)
    {
        if (pair.second > maxCount)
        {
            maxCount = pair.second;
            answer = pair.first;
        }

        else if (pair.second == maxCount)
        {
            answer += pair.first;
        }
    }

    std::cout << answer;

    return 0;
}
