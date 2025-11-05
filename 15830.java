import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int count;
    static double horizontalSpeed, width, depth, sumDepth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());

        horizontalSpeed = Double.parseDouble(st.nextToken());
        width = Double.parseDouble(st.nextToken());
        depth = Double.parseDouble(st.nextToken());

        double time = width / horizontalSpeed;  // 벽에 부딪치는데 걸리는 시간

        while (depth > 0) {
            sumDepth += 5 * time * time;  // 수직 이동 거리

            if (sumDepth <= depth) {  // 벽에 부딪힌다면
                count += 1;
                time = time * 5 / 4;
            } else {
                break;
            }
        }

        System.out.print(count);
    }
}
