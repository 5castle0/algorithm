import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

    static HashMap<String, Integer> map;
    static int[] arr;
    static int size = 200000;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int f = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            arr = new int[size + 1];
            count = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                arr[i] = i;
            }
            int index = 1; // 사람 index

            while (f-- > 0) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String friend1 = st.nextToken();
                String friend2 = st.nextToken();

                if (!map.containsKey(friend1)) {
                    map.put(friend1, index);
                    count[index] = 1;
                    index++;
                }

                if (!map.containsKey(friend2)) {
                    map.put(friend2, index);
                    count[index] = 1;
                    index++;
                }

                bw.write(union(map.get(friend1), map.get(friend2)) + "\n");
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static int find(int a) {
        if (arr[a] == a) {
            return a;
        }

        return arr[a] = find(arr[a]);
    }

    private static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        // 이미 친구인 경우
        if (rootA == rootB) {
            return count[rootA];
        }

        if (rootA > rootB) {
            arr[rootB] = rootA;
            count[rootA] += count[rootB];
            count[rootB] = count[rootA];
        } else {
            arr[rootA] = rootB;
            count[rootB] += count[rootA];
            count[rootA] = count[rootB];
        }

        return count[rootA];
    }
}