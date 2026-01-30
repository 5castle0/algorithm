import java.io.*;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 7662
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            PriorityQueue<Integer> pqReversed = new PriorityQueue<>(Comparator.reverseOrder());
            HashMap<Integer, Integer> hashMap = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String instruction = st.nextToken();
                int data = Integer.parseInt(st.nextToken());

                if (instruction.equals("I")) {
                    if (hashMap.containsKey(data)) {
                        int temp = hashMap.get(data) + 1;
                        hashMap.put(data, temp);
                    } else {
                        hashMap.put(data, 1);
                    }
                    pq.add(data);
                    pqReversed.add(data);
                } else { // instruction=="D"
                    if (data == 1) {
                        int tempSize = pqReversed.size();
                        while (tempSize-- > 0) {
                            int poll = pqReversed.poll();
                            if (hashMap.containsKey(poll)) {
                                if (hashMap.get(poll) == 1) {
                                    hashMap.remove(poll);
                                } else {
                                    int temp = hashMap.get(poll) - 1;
                                    hashMap.put(poll, temp);
                                }
                                break;
                            }
                        }
                    } else if (data == -1) {
                        int tempSize = pq.size();
                        while (tempSize-- > 0) {
                            int poll = pq.poll();
                            if (hashMap.containsKey(poll)) {
                                if (hashMap.get(poll) == 1) {
                                    hashMap.remove(poll);
                                } else {
                                    int temp = hashMap.get(poll) - 1;
                                    hashMap.put(poll, temp);
                                }
                                break;
                            }
                        }
                    }
                }
            }

            if (hashMap.isEmpty()) {
                bw.write("EMPTY\n");
            } else {
                while (true) {
                    int x = pqReversed.poll();
                    if (hashMap.containsKey(x)) {
                        bw.write(x + " ");
                        break;
                    }
                }

                while (true) {
                    int x = pq.poll();
                    if (hashMap.containsKey(x)) {
                        bw.write(x + "\n");
                        break;
                    }
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}