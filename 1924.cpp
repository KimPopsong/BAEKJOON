#include <stdio.h>

int main()
{
	int mon, day, i, cnt = 0;

	scanf("%d %d", &mon, &day);

	for (i = 1; i < mon; i++)
	{
		switch(i)
		{
			case(1):
			case(3):
			case(5):
			case(7):
			case(8):
			case(10):
			case(12):
				cnt += 31;
				break;

			case(2):
				cnt += 28;
				break;

			default:
				cnt += 30;
				break;
		}
	}

	cnt += day;
	
	switch (cnt % 7)
	{
	case(1):
		printf("MON\n");
		break;
    
	case(2):
		printf("TUE\n");
		break;
    
	case(3):
		printf("WED\n");
		break; 
    
	case(4):
		printf("THU\n");
		break; 
    
	case(5):
		printf("FRI\n");
		break;
    
	case(6):
		printf("SAT\n");
		break;
    
	default:
		printf("SUN\n");
		break;
	}

	return 0;
}
