import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static char[][] arr;
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 세로
        int m = Integer.parseInt(st.nextToken()); // 가로

        arr = new char[n][m];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                arr[i][j] =  str.charAt(j);
            }
        }

        for(int i=0; i<= n-8; i++){
            for(int j=0; j<= m-8; j++){
                int result = find(i,j);
                if(min>result) min = result;
            }
        }

        bw.write(String.valueOf(min));

        bw.flush();
        bw.close();
        br.close();
    }

   public static int find(int height , int width){
        int count = 0;
        String[] board = {"WBWBWBWB", "BWBWBWBW"};
        int version = 0;

        for(int i=height; i<height+8; i++){
            for(int j=0; j<8; j++){
                int nowWidth = width + j;
                if(arr[i][nowWidth] != board[version].charAt(j)){
                    count++;
                }
            }

            if(version==0) { // 줄바꿈시 맨 앞칸 색 변경
                version = 1;
            }else{
                version = 0;
            }

        }

        return Math.min(count, 64- count); // 어떤 것을 기준으로 했는지에 따라 달라짐

   }

}