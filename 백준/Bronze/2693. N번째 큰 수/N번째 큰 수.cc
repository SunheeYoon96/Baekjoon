#include <iostream>
#include <vector>
#include <algorithm>

int main() 
{
	int N = 3;
	int nums[10];
	int tc;
	std::cin >> tc;

	for (int i = 0; i < tc; i++)
	{
		for (int i = 0; i < 10; i++)
		{
			std::cin >> nums[i];
		}

		std::sort(nums, nums+10, std::greater<int>());

		std::cout << nums[2] << std::endl;
	}
}