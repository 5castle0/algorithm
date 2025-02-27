import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long s = Long.parseLong(br.readLine());

        long temp = 0;
        long count = 0;

        for (int i=1; ; i++) {

            if(temp>s){
                break;
            }

            count++;
            temp+=i;

        }

        System.out.println(count-1);

        br.close();
    }
}