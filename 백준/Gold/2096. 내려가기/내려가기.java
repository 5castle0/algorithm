import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        // 초기값 입력
        StringTokenizer st = new StringTokenizer(br.readLine());
        int init1 = Integer.parseInt(st.nextToken());
        int init2 = Integer.parseInt(st.nextToken());
        int init3 = Integer.parseInt(st.nextToken());
        int[] min = {init1, init2, init3};
        int[] max = {init1, init2, init3};

        for (int i = 1; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            int temp1 = min[0];
            int temp2 = min[1];
            int temp3 = min[2];

            min[0] = a + Math.min(temp1, temp2);
            min[1] = b + Math.min(temp1, Math.min(temp2, temp3));
            min[2] = c + Math.min(temp2, temp3);

            int temp4 = max[0];
            int temp5 = max[1];
            int temp6 = max[2];

            max[0] = a + Math.max(temp4, temp5);
            max[1] = b + Math.max(temp4, Math.max(temp5, temp6));
            max[2] = c + Math.max(temp5, temp6);
        }

        bw.write(Math.max(max[0], Math.max(max[1], max[2]))
                + " "
                + Math.min(min[0], Math.min(min[1], min[2])));

        bw.flush();
        bw.close();
        br.close();
    }
}