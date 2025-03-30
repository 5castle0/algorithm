import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        HashMap<Character,Integer> map = new HashMap<>();
        String alphabet = "abcdefghijklmnopqrstuvwxyz";

        for(int i = 0; i < alphabet.length(); i++){
            map.put(alphabet.charAt(i),-1);
        }

        String input = br.readLine();

        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(map.get(c) == -1){
                map.replace(c,i);
            }
        }

        for(Character c : map.keySet()){
            bw.write(map.get(c)+" ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}