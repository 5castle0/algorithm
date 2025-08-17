import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String n = br.readLine();
        int[] arr = new int[2];

        char letter = n.charAt(0);

        for(int i=1; i<n.length(); i++){
           if(n.charAt(i) != letter){
               arr[Integer.parseInt(String.valueOf(letter))]++;
               letter = n.charAt(i);
           }
        }

        arr[Integer.parseInt(String.valueOf(letter))]++; // 마지막

        bw.write(String.valueOf(Math.min(arr[0], arr[1])));

        bw.flush();
        bw.close();
        br.close();
    }

}
