import java.util.*;
import java.io.*;

public class Main {
    static int nodeNumber, deleteNode, answer = 0;
    static Map<Integer, Set<Integer>> nodes;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        // 입력부 시작

        nodeNumber = Integer.parseInt(br.readLine());

        nodes = new HashMap<>();

        st = new StringTokenizer(br.readLine());
        for (int node = 0; node < nodeNumber; node++)
        {
            int parent = Integer.parseInt(st.nextToken());

            if (!nodes.containsKey(parent))
            {
                nodes.put(parent, new HashSet<>());
            }

            nodes.get(parent).add(node);
        }

        deleteNode = Integer.parseInt(br.readLine());

        // 입력부 종료

        ArrayDeque<Integer> bfs = new ArrayDeque<>();

        if (!nodes.get(-1).contains(deleteNode))
        {
            bfs.add(-1);
        }

        while (!bfs.isEmpty())
        {
            int node = bfs.removeFirst();

            if (nodes.containsKey(node))
            {
                int count = 0;
                Set<Integer> children = nodes.get(node);

                for (int child : children)
                {
                    if (child != deleteNode)
                    {
                        bfs.addLast(child);
                        count += 1;
                    }
                }

                if (count == 0)
                {
                    answer += 1;
                }
            }

            else
            {
                answer += 1;
            }
        }

        System.out.print(answer);
    }
}
