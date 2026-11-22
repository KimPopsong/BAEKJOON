#include <stdio.h>

int main(void)
{
    int exerciseMinutes, minPulse, maxPulse, exercisePulse, restPulse;

    scanf("%d %d %d %d %d", &exerciseMinutes, &minPulse, &maxPulse, &exercisePulse, &restPulse);

    if (minPulse + exercisePulse > maxPulse)
    {
        printf("-1\n");

        return 0;
    }

    int currentPulse = minPulse;
    int exerciseTime = 0;
    int totalTime = 0;

    while (exerciseTime < exerciseMinutes)
    {
        if (currentPulse + exercisePulse <= maxPulse)
        {
            currentPulse += exercisePulse;
            exerciseTime++;
        }

        else
        {
            int afterRest = currentPulse - restPulse;
            currentPulse = (afterRest < minPulse) ? minPulse : afterRest;
        }

        totalTime++;
    }

    printf("%d\n", totalTime);

    return 0;
}
