import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] order;
    static int[] enter; // 진입차수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 가수의 수
        int m = Integer.parseInt(st.nextToken()); // pd의 수

        order = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            order[i] = new ArrayList<>();
        }

        enter = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int[] temp = new int[num];
            for (int j = 0; j < num; j++) {
                temp[j] = Integer.parseInt(st.nextToken());
            }

            for (int j = 0; j < num - 1; j++) {
                int singer = temp[j];
                int next = temp[j + 1];

                order[singer].add(next);
                enter[next]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (enter[i] == 0) {
                queue.add(i);
            }
        }

        Queue<Integer> answer = new LinkedList<>();

        while (!queue.isEmpty()) {
            int singer = queue.poll();
            answer.add(singer);

            for (int i : order[singer]) {
                enter[i]--;

                if (enter[i] == 0) {
                    queue.add(i);
                }
            }
        }

        if (answer.size() == n) {
            for (int i : answer) {
                bw.write(i + "\n");
            }
        } else {
            bw.write("0");
        }


        bw.flush();
        bw.close();
        br.close();
    }
}