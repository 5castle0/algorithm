import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int h = Integer.parseInt(br.readLine());
        int w = Integer.parseInt(br.readLine());

        int radius = Math.min(h,w)*100/2;
        
        bw.write(String.valueOf(radius));

        bw.flush();
        bw.close();
        br.close();
    }
}