import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        boolean[][] world = new boolean[h][w];

        // 블록 입력
        st = new StringTokenizer(br.readLine());
        int tempW = 0;
        while (st.hasMoreTokens()) {
            int tempH = Integer.parseInt(st.nextToken());
            for (int i = h - tempH; i < h; i++) {
                world[i][tempW] = true;
            }
            tempW++;
        }

        int raindrop = 0;
        for (int i = h - 1; i >= 0; i--) {
            boolean left = false;
            int count = 0;
            for (int j = 0; j < w; j++) {

                // 블록이 없는 경우 = 빗물이 쌓일 수 있는 경우
                if (!world[i][j]) {

                    // 왼쪽 블록이 있는 경우
                    if (left) {
                        count++;
                    }
                }

                // 블록이 있는 경우
                else {
                    // 왼쪽이 이미 있는 경우
                    if (left) {
                        raindrop += count;
                        count = 0;
                    }
                    // 왼쪽이 없는 경우 = 지금 블록이 왼쪽이 되는 경우
                    else {
                        left = true;
                    }
                }
            }
        }

        bw.write(String.valueOf(raindrop));
        bw.flush();
        bw.close();
        br.close();
    }
}