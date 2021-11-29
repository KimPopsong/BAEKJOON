///////////////////////////////
// Fast Input Output
#include <iostream>

int main()
{
  std::ios_base::sync_with_stdio(false);
  std::cin.tie(NULL);
  std::cout.tie(NULL);

  std::cout << "\n";  // Faster than std::endl
  
  return 0;
}

///////////////////////////////
// Preventing exponential notation
#include <iostream>

int main()
{
  std::cout << std::fixed;
	std::cout.precision(0);
  
  return 0;
}

///////////////////////////////
