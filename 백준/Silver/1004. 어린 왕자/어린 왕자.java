import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static int x1,y1,x2,y2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            int n = Integer.parseInt(br.readLine());
            int count = 0;
            // 시작 : 시작좌표를 포함한 원 && 도착 좌표는 원 밖 -> +1
            // 도착 : 도착좌표를 포함한 원 && 시작 좌표가 원 밖 -> +1
            while(n-->0){
                st = new StringTokenizer(br.readLine());
                int cx = Integer.parseInt(st.nextToken());
                int cy = Integer.parseInt(st.nextToken());
                int cr = Integer.parseInt(st.nextToken());

                if(inCircle(cx, cy, cr)) count++;
                if(outCircle(cx, cy, cr)) count++;

            }
            bw.write(count + "\n");

        }

        bw.flush();
        bw.close();
        br.close();

    }

    // 시작 좌표가 특정 원 안 && 도착 좌표는 원 밖
    private static boolean inCircle(int cx, int cy, int cr) {
        int distanceWithStart= (x1-cx) * (x1-cx) + (y1-cy) * (y1-cy); // 제곱형태
        int distanceWithArrive = (x2-cx) * (x2-cx) + (y2-cy) * (y2-cy);
        int round = cr * cr; // 비교를 위한 제곱형태
        return distanceWithStart<round && distanceWithArrive>round;
    }

    // 도착 좌표가 특정 원 안 && 출발 좌표는 원 밖인지 검사
    private static boolean outCircle(int cx, int cy, int cr) {
        int distanceWithStart= (x1-cx) * (x1-cx) + (y1-cy) * (y1-cy); // 제곱형태
        int distanceWithArrive = (x2-cx) * (x2-cx) + (y2-cy) * (y2-cy);
        int round = cr * cr; // 비교를 위한 제곱형태

        return distanceWithStart>round && distanceWithArrive<round;
    }

}