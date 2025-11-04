import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            long x1 = Integer.parseInt(st.nextToken());
            long y1 = Integer.parseInt(st.nextToken());
            long r1 = Integer.parseInt(st.nextToken());
            long x2 = Integer.parseInt(st.nextToken());
            long y2 = Integer.parseInt(st.nextToken());
            long r2 = Integer.parseInt(st.nextToken());

            if(x1==x2 && y1==y2){
                if(r1==r2){
                    bw.write("-1 \n");
                }
                else{
                    bw.write("0 \n");
                }
            }
            else{
                long distance = (x1-x2) * (x1-x2) + (y1-y2) * (y1-y2); // 제곱된 형태
                long r1r2 = (r1+r2) * (r1+r2); // distance와 비교하기 위해 제곱
                long rdiff = (r1-r2) * (r1-r2);

                if(distance > r1r2){
                    bw.write("0 \n");
                } else if (distance < rdiff) {
                    bw.write("0 \n");
                } else if (distance == r1r2) {
                    bw.write("1 \n");
                } else if (distance == rdiff) {
                    bw.write("1 \n");
                } else{
                    bw.write("2 \n");
                }

            }
        }

        bw.flush();
        bw.close();
        br.close();

    }

}

// 1.  좌표가 같은 경우
// 1-1. 반지름이 같음
// 1-2. 반지름이 다름

// 2. 좌표가 다른 경우
// 2-1. 두 점 사이의 거리 > r1+r2
// 2-2. 원안에 또다른 작은 원이 들어있는 경우
// 2-2. 두 점 사이의 거리 = r1+r2 (외접하는 경우)
// 2-3. 내접하는 경우
// 2-4. 두 점 사이의 거리 < r1+r2