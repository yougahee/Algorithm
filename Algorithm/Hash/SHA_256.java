package Algorithm.Hash;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.security.MessageDigest;

public class SHA_256 {
    public static void main(String[] args) throws Exception{
        String s ;
        String sha;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        MessageDigest md = MessageDigest.getInstance("SHA-256");

        s = br.readLine();

        md.update(s.getBytes("UTF-8"));
        byte byteData[] = md.digest();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i< byteData.length; i++) {
            sb.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
        }
        sha = sb.toString();

        System.out.println(sha);

        br.close();
    }
}
