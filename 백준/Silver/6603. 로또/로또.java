import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

// 6603
public class Main {

    static int k;
    static int[] num;
    static List<Integer> set;
    static boolean[] visited;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());

            if (k == 0) {
                break;
            }

            num = new int[k];
            for (int i = 0; i < k; i++) {
                num[i] = Integer.parseInt(st.nextToken());
            }

            set = new ArrayList<>();
            visited = new boolean[k];

            lotto(0);

            bw.write("\n");

        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static void lotto(int index) throws IOException {

        if (set.size() == 6) {
            for (int i : set) {
                bw.write(i + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = index; i < k; i++) {
            if (!visited[i]) {
                visited[i] = true;
                set.add(num[i]);
                lotto(i+1);
                visited[i] = false;
                set.remove(set.size()-1);
            }
        }
    }
}