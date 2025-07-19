import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int k = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        int xMax = Integer.MIN_VALUE;
        int xIndex = 0;
        int yMax = Integer.MIN_VALUE;
        int yIndex = 0;

        for(int i=0; i<6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            dir[i] = a;
            len[i] = b;
            if (a == 1 || a == 2) { // x축 이동
                if (xMax < b){
                    xMax = b;
                    xIndex = i;
                }
            }else{
                if (yMax < b) {
                    yMax = b;
                    yIndex = i;
                }
            }
        }

        int tempx , tempy;

        if(xIndex > 2) tempy = len[xIndex-3];
        else tempy = len[xIndex+3];
        if(yIndex > 2) tempx = len[yIndex-3];
        else tempx = len[yIndex+3];

        bw.write(String.valueOf((xMax*yMax - tempx*tempy)*k));

        bw.flush();
        bw.close();
        br.close();
    }

}