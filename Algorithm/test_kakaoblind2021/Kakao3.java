package Algorithm.test_kakaoblind2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Kakao3 {
    public static void main(String[] args) {

        String[] info = {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
        String[] query = {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};

        System.out.println(Arrays.toString(solution(info, query)));
    }

    //효율성 생각
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[] infos;
        TreeNode[] node = new TreeNode[info.length];
        ArrayList<TreeNode> arrayList = new ArrayList<>();

        for(int i=0; i<info.length; i++) {
            infos = info[i].split(" ");
            arrayList.add(new TreeNode(infos[0], infos[1], infos[2], infos[3], Integer.parseInt(infos[4])));
            node[i] = new TreeNode(infos[0], infos[1], infos[2], infos[3], Integer.parseInt(infos[4]));
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replace("and ", "");
            String[] queryInfo = query[i].split(" ");

            for(int k=0; k<queryInfo.length; k++) {

                if (queryInfo[k].equals("-"))
                    continue;

                //숫자계산
                if(k==4) {

                }
                else {
                    Arrays.sort(node, new Comparator<TreeNode>() {
                        @Override
                        public int compare(TreeNode o1, TreeNode o2) {

                            return 0;
                        }
                    });
                }
            }

        }



        return answer;
    }

/*
    public static int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];

        String[] infos;
        TreeNode[] node = new TreeNode[info.length];


        for(int i=0; i<info.length; i++) {
            infos = info[i].split(" ");
            node[i] = new TreeNode(infos[0], infos[1], infos[2], infos[3], Integer.parseInt(infos[4]));
        }

        for(int i=0; i<query.length; i++) {
            query[i] = query[i].replace("and ", "");
            String[] queryInfo = query[i].split(" ");
            int cnt =0;

            for(int j=0; j<node.length; j++) {
                if(queryInfo[0].equals("-") || queryInfo[0].equals(node[j].lan)) {
                    if(queryInfo[1].equals("-") || queryInfo[1].equals(node[j].occupation)) {
                        if(queryInfo[2].equals("-") || queryInfo[2].equals(node[j].career)) {
                            if(queryInfo[3].equals("-") || queryInfo[3].equals(node[j].food)) {
                                if(queryInfo[4].equals("-") || Integer.parseInt(queryInfo[4]) <= node[j].score) {
                                    cnt++;
                                }
                            }
                        }
                    }
                }
            }

            answer[i] = cnt;
        }

        return answer;
    }*/

    static class TreeNode {
        String lan;
        String occupation;
        String career;
        String food;
        int score;

        TreeNode leftNode;
        TreeNode rightNode;

        TreeNode(String lan,
                String occupation,
                String career,
                String food,
                int score) {
            this.lan = lan;
            this.career = career;
            this.occupation = occupation;
            this.food = food;
            this.score = score;
        }


    }

    public static void sorting() {

    }
}
