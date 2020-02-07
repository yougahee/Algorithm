import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Node{
    String name;
    int networkCnt;

    public Node(String name, int networkCnt) {
        this.name = name;
        this.networkCnt = networkCnt;
    }

    public Node(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getNetworkCnt() {
        return networkCnt;
    }
}

public class FriendNetwork {

    static HashMap<String, Node> hashMap = new HashMap<>();

    public static void main(String[] args) throws Exception{

        ArrayList<Integer> parent = new ArrayList<>();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for(int i=0; i<testCase; i++) {
            hashMap.clear();
            int F = Integer.parseInt(br.readLine());

            for(int j=0; j<F; j++) {
                StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());

                String first = stringTokenizer.nextToken();
                String second = stringTokenizer.nextToken();

                if(!hashMap.containsKey(first)) {
                    hashMap.put(first, new Node(first, 1));
                }
                if(!hashMap.containsKey(second)) {
                    hashMap.put(second, new Node(second, 1));
                }

                union(first, second);
                sb.append(hashMap.get(find(first)).getNetworkCnt() + "\n");
            }
        }

        System.out.println(sb.toString());
    }


    public static void union(String first, String second) {
        String firstKey = find(first);
        String secondKey = find(second);

        if(firstKey.equals(secondKey)) return;

        hashMap.replace(firstKey, new Node(firstKey, hashMap.get(firstKey).getNetworkCnt() + hashMap.get(secondKey).getNetworkCnt()));
        hashMap.replace(secondKey, new Node(firstKey));
    }

    public static String find(String key) {

        String value = hashMap.get(key).getName();

        if(key.equals(value)) {
            return key;
        }

        String rootKey = find(value);

        hashMap.replace(key, new Node(rootKey));

        return rootKey;
    }
}
