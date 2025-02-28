import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] alist = new int[10];
        int[] blist = new int[10];

        for(int i=0; i<10;i++){
            alist[i] = Integer.parseInt(br.readLine());
        }
        for(int i=0; i<10;i++){
            blist[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(alist);
        Arrays.sort(blist);

        int scoreA = 0;
        int scoreB = 0;

        for(int i=0; i<3; i++){
            scoreA += alist[9-i];
            scoreB += blist[9-i];
        }

        System.out.println(scoreA+" "+scoreB);

        br.close();
    }
}