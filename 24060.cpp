#include <iostream>
#include <algorithm>

void MergeSort(int p, int r);
void Merge(int p, int q, int r);

int arr[500001];
int temp[500001];
int count = 0, saveTime;

void MergeSort(int p, int r)
{
	int q;

	if (p < r)
	{
		q = (p + r) / 2;

		MergeSort(p, q);
		MergeSort(q + 1, r);
		Merge(p, q, r);
	}
}

void Merge(int p, int q, int r)
{
	int i = p, j = q + 1, t = 1;

	while (i <= q && j <= r)
	{
		if (arr[i] <= arr[j])
		{
			temp[t++] = arr[i++];
		}

		else
		{
			temp[t++] = arr[j++];
		}
	}

	while (i <= q)
	{
		temp[t++] = arr[i++];
	}

	while (j <= r)
	{
		temp[t++] = arr[j++];
	}

	i = p;
	t = 1;

	while (i <= r)
	{
		arr[i++] = temp[t++];

		count++;
		if (count == saveTime)
		{
			std::cout << arr[i - 1];

			exit(0);
		}
	}
}

int main()
{
	std::ios_base::sync_with_stdio(false);
	std::cin.tie(NULL);
	std::cout.tie(NULL);

	int arraySize;
	int maxTime;

	std::cin >> arraySize >> saveTime;

	maxTime = (arraySize - 2) * 4;

	for (int i = 0; i < arraySize; i++)
	{
		std::cin >> arr[i];
	}

	if (saveTime > maxTime)
	{
		std::cout << "-1" << "\n";

		return 0;
	}

	MergeSort(0, arraySize - 1);

	return 0;
}
