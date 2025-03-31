import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        n = 1000 - n;
        int count = 0;

        int index = 0;
        int[] arr = {500,100,50,10,5,1};

        while(n!=0){
            if(n>=arr[index]){
                int temp = n/arr[index];
                count += temp;
                n-=temp*arr[index];
            }
            index++;
        }

        bw.write(String.valueOf(count));
        bw.flush();
        bw.close();
        br.close();
    }
}