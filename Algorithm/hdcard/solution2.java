package Algorithm.hdcard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class solution2 {
    public static void main(String[] args){

        int answer =0;

        String[] ip_addrs= {"5.5.5.5", "155.123.124.111", "10.16.125.0", "155.123.124.111", "5.5.5.5", "155.123.124.111", "10.16.125.0", "10.16.125.0"};
        String[] langs = {"Java", "C++", "Python3", "C#", "Java", "C", "Python3", "JavaScript"};
        int[] scores = {294, 197, 373, 45, 294, 62, 373, 373};

        for(int i=0; i<langs.length; i++) {
            if(langs[i].equals("C++") || langs[i].equals("C#")||langs[i].equals("C")) {
                langs[i] = "C";
            }
        }

        int[] visited = new int[ip_addrs.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i=0; i<ip_addrs.length; i++) {
            int cnt=1;
            queue.clear();
            arrayList.clear();
            for(int j=i+1; j<ip_addrs.length; j++) {
                //비교
                if(ip_addrs[i].equals(ip_addrs[j]) && visited[i] ==0 && visited[j] == 0){

                    visited[j] =1;
                    queue.add(j);
                    arrayList.add(j);
                    cnt++;

                    //System.out.println(i + "<- i,  j-> " + j) ;
                }
            }

            //System.out.println(cnt);

            //부정참가자 아님.
            if(cnt ==1 && visited[i] ==0) {
                visited[i] =1;
            }
            //접속한 학생이 2명
            if(cnt ==2) {
                int queue2 = arrayList.get(0);
                String a_lang = langs[i];
                String b_lang = langs[queue2];

                if(a_lang.equals(b_lang) && scores[i] == scores[queue2]){
                    visited[i] =2;
                    visited[queue2] =2;
                }else{
                    visited[i] =1;
                    visited[queue2] =1;
                }
            }
            else if(cnt ==3) {
                //2명일때도 고려를 해줘야함..
                int langCnt=0;

                for(int k=0; k<2; k++) {

                    if(langs[i].equals(langs[arrayList.get(k)]))
                    {
                        langCnt++;
                        /*if(scores[arrayList.get(k)] == scores[i]) {
                            visited[i] =2;
                            visited[arrayList.get(k)] =2;
                        }else{
                            visited[i] =1;
                            visited[arrayList.get(k)] =1;
                        }*/
                    }
                }

                if(langs[arrayList.get(0)].equals(langs[arrayList.get(1)])){
                    langCnt++;
                   /* if(scores[arrayList.get(0)] == scores[arrayList.get(1)]){
                        visited[arrayList.get(1)] =2;
                        visited[arrayList.get(0)] =2;
                    }else{
                        visited[arrayList.get(1)] =1;
                        visited[arrayList.get(0)] =1;
                    }*/
                }

               System.out.println("langdk" + langCnt);

                /*//2명일때,
                if(langCnt==1) {
                    //성적도 같은지 보고
                    if(scores[arrayList.get(0)] == scores[arrayList.get(1)]){
                        visited[arrayList.get(1)] =2;
                        visited[arrayList.get(0)] =2;
                    }else if(scores[arrayList.get(0)] == scores[i]) {
                        visited[i] =2;
                        visited[arrayList.get(0)] =2;
                    }else if(scores[arrayList.get(1)] == scores[i]) {
                        visited[i] =2;
                        visited[arrayList.get(1)] =2;
                    }
                }*/
                if(langCnt ==3) {
                    visited[i]=2;
                    visited[arrayList.get(1)] =2;
                    visited[arrayList.get(0)] =2;
                }else{
                    visited[i]=1;
                    visited[arrayList.get(1)] =1;
                    visited[arrayList.get(0)] =1;
                }

            }
            //4명 이상이면 모두 부정참가자
            else if(cnt >= 4) {

                while (!queue.isEmpty()) {
                    visited[i] =2;
                    visited[queue.poll()] =2;
                }

            }

        }

        for(int i=0; i<ip_addrs.length; i++) {
            if(visited[i]==1)
            {
                answer++;
            }
        }

        System.out.println(answer);
    }
}
