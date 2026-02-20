import java.io.*;
import java.util.StringTokenizer;

// 1976
public class Main {

    static int[] city;
    static int[] sequence;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine()); // 도시의 수
        int m = Integer.parseInt(br.readLine()); // 여행 계획에 속한 도시들의 수

        city = new int[n];
        for (int i = 0; i < n; i++) {
            city[i] = i;
        }
        
        // 도시 연결정보 입력
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                int info = Integer.parseInt(st.nextToken());

                if (info == 1) {
                    union(i, j);
                }
            }
        }

        // 여행 경로 입력
        sequence = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            sequence[i] = Integer.parseInt(st.nextToken()) - 1;
        }

        // 가능 여부 판별
        boolean flag = true;
        for (int i = 0; i < m - 1; i++) {
            if (find(sequence[i]) != find(sequence[i + 1])) {
                flag = false;
                break;
            }
        }

        if (flag) {
            bw.write("YES");
        } else {
            bw.write("NO");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);

        if (aRoot != bRoot) {
            if (aRoot > bRoot) {
                city[aRoot] = bRoot;
            } else {
                city[bRoot] = aRoot;
            }
        }
    }

    private static int find(int n) {
        if (city[n] != n) {
            city[n] = find(city[n]);
        }

        return city[n];
    }
}