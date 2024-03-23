import java.util.*;

public class Main {

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int subin, sister;
        int time = 0;  // 찾는데 걸리는 시간
        int[] visited = new int[100001];  // 부모 노드 저장 및 방문 여부 확인
        Arrays.fill(visited, -1);  // 0의 위치도 방문이 가능하므로 -1로 초기화
        Queue<Integer> BFS = new LinkedList<>();

        subin = scanner.nextInt();
        sister = scanner.nextInt();

        if (subin > sister)  // 수빈이 동생보다 크다면 X - 1밖에 움직이지 못함
        {
            System.out.println(subin - sister);  // 수빈과 동생과의 거리를 출력

            for (int i = subin; i >= sister; i--)
            {
                System.out.print(i + " ");  // 역순으로 출력
            }

            return;
        }

        BFS.add(subin);
        visited[subin] = -2;  // 출발 지점

        for (time = 0; ; time++)
        {
            Queue<Integer> tempQueue = new LinkedList<>();  // 다음에 찾을 값들을 넣어두고 BFS에 추가

            while (!BFS.isEmpty())
            {
                int top = BFS.element();  // 오버헤드 최소화

                if (top == sister)
                {
                    System.out.println(time);  // 시간 출력

                    Deque<Integer> answer = new ArrayDeque<>();  // visited를 거슬러 올라가며 저장 후, 역순으로 출력

                    while (sister != -2)
                    {
                        answer.add(sister);

                        sister = visited[sister];
                    }

                    while (!answer.isEmpty())
                    {
                        System.out.print(answer.pollLast() + " ");
                    }

                    return;
                }

                else
                {
                    if (top - 1 >= 0)  // 범위 안에 있다면
                    {
                        if (visited[top - 1] == -1)  // X - 1을 방문하지 않았다면
                        {
                            tempQueue.add(top - 1);  // 다음에 방문할 위치
                            visited[top - 1] = top;  // 이동 전 지점의 위치를 저장
                        }
                    }

                    if (top + 1 <= 100000)  // 범위 안에 있다면
                    {
                        if (visited[top + 1] == -1)  // X + 1을 방문하지 않았다면
                        {
                            tempQueue.add(top + 1);
                            visited[top + 1] = top;
                        }
                    }

                    if (top * 2 <= 100000)  // 범위 안에 있다면
                    {
                        if (visited[top * 2] == -1)  // X * 2를 방문하지 않았다면
                        {
                            tempQueue.add(top * 2);
                            visited[top * 2] = top;
                        }
                    }

                    BFS.remove();  // 맨 위의 값 삭제
                }
            }

            BFS.addAll(tempQueue);  // BFS에 tempQueue를 넣어줌
        }
    }
}
