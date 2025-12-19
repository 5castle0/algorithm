import java.io.*;
import java.util.StringTokenizer;

// 2630
public class Main {

    static int[][] paper;
    static int blue = 0;
    static int white = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 입력
        int n = Integer.parseInt(br.readLine());
        paper = new int[n+1][n+1];
        for(int i=1; i<=n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=1; j<=n; j++){
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        investigation(1, 1, n);

        bw.write(white + "\n" + blue);

        bw.flush();
        bw.close();
        br.close();
    }

    // 잘라진 종이가 모두 같은 색인지 확인
    public static boolean check(int x, int y, int n){
        int flag = paper[x][y]; // 기준이 되는 색

        for(int i=x; i<x+n; i++){
            for(int j=y; j<y+n; j++){
                if(flag != paper[i][j]){
                    return false;
                }
            }
        }

        // 완성된 색종이
        return true;
    }

    // 조사 && 자르기
    public static void investigation(int x, int y, int n){

        if(check(x,y,n)){
            if(paper[x][y]==1){
                blue++;
            }else{
                white++;
            }
            return;
        }

        investigation(x, y, n/2); // 1구역
        investigation(x+n/2, y,n/2); // 2구역
        investigation(x, y+n/2, n/2); // 3구역
        investigation(x+n/2,y+n/2,n/2); // 4구역
    }
}


/*
    재귀함수에 들어갈 기능
    모두 같은 색인지 체크 -> 같은색이라면 색종이 수 ++
    아니면 시분면 조사
 */
