#include <iostream>
#include <vector>

long long maxMult = 0, sumNumber, maxDepth;
void dfs(int depth, int start, int sum, std::vector<int> &numbers);

int main()
{
    std::cin >> sumNumber >> maxDepth;

    std::vector<int> numbers;
    dfs(0, 1, 0, numbers);

    std::cout << maxMult << std::endl;

    return 0;
}

void dfs(int depth, int start, int sum, std::vector<int> &numbers)
{
    if (depth == maxDepth)
    {
        long long mult = 1;

        for (int n : numbers)
        {
            mult *= n;
        }

        maxMult = std::max(maxMult, mult);

        return;
    }

    for (int i = start; i <= sumNumber - sum; i++)
    {
        numbers.push_back(i);
        dfs(depth + 1, i, sum + i, numbers);
        numbers.pop_back();
    }
}
