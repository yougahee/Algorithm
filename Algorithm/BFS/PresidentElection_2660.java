package Algorithm.BFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class PresidentElection_2660 {

    static int[][] friends;
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] score = new int[N];
        friends = new int[N][N];

        while (true){
            int a,b;
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1) break;

            friends[a-1][b-1] = 1;
            friends[b-1][a-1] = 1;
        }

        for(int i=0; i<N; i++) {
            int scoreMax =0;
            for(int j=0; j<N; j++) {
                if(i==j) continue;
                //max값을 구하는 것임.
                if(friends[i][j] == 1)
                    scoreMax = Math.max(1, scoreMax);
                else
                    scoreMax = Math.max(scoreMax, getScore(i,j));
            }
            score[i] = scoreMax;
        }

        ArrayList<Integer> answer = new ArrayList<>();
        int min = N+1;
        for (int i = 0; i < score.length; i++) {
            if(min > score[i]) {
                min = score[i];
                answer.clear();
                answer.add(i+1);
            }
            else if( min == score[i]) {
                answer.add(i+1);
            }
        }

        System.out.println(min + " " + answer.size());
        for (Integer i : answer) System.out.print( i + " ");
    }

    public static int getScore(int s, int e) {
        PriorityQueue<Score> q = new PriorityQueue<>((o1, o2) -> o1.score - o2.score);
        q.add(new Score(s, 0));

        while (!q.isEmpty()) {
            Score sc = q.poll();

            for(int i=0; i<N; i++) {
                if(sc.s == e) return sc.score;
                if(friends[sc.s][i] == 1) q.add(new Score(i, sc.score + 1));
            }
        }

        return 0;
    }

    static class Score{
        int s, score;

        public Score(int s, int score) {
            this.s = s;
            this.score = score;
        }
    }
}
