package Algorithm.naver2021codingtest;

import java.util.Arrays;

public class Test2 {
    public static void main(String[] args) {
        int[][] edges = {{0,2},{2,1},{2,4},{3,5},{5,4},{5,7},{7,6},{6,8}};
        System.out.println(Arrays.toString(solution(9,edges)));
    }

    public static int[] solution(int n, int[][] edges) {
        int[] answer = new int[2];



        return answer;
    }

}


/* C++ 코드
 //노드에서 3개로 만드는 것
#inclue <iostream>
#include <vector>
#include <string.h>
using namespace std;

int N;
int node;
int max_node;
vector<vector<int>> edge;
vector<vector<int>> vc;
vector<int> ans;

bool check[100];
bool answer=false;
int dfs(int v){
    int ret =0;
    for(int t : vc[v]){
        if(check[t])continue;
        check[t]=1;
        ret += dfs(t);
    }
    return ret+1;
}


void get(int v, vector<int> list){
    if(answer)return;
    if(list.size()==2){
        vc.clear();
        vc.resize(node);
        for(int i=0; i<N;i++){
            if(i==list[0] || i==list[1])continue;
            vc[edge[i][0]].push_back(edge[i][1]);
            vc[edge[i][1]].push_back(edge[i][0]);
        }
        memset(check, 0, sizeof(check));

        check[0]=1;
        int last = dfs(0);
        for(int i=1; i<node;i++){
            if(check[i])continue;
            check[i]=1;
            int t = dfs(i);
            if(last!=t)return;
        }

        answer=true;
        ans = list;
        return;
    }

    for(int i=v; i<N;i++){
        list.push_back(i);
        get(i+1,list);
        list.pop_back();
    }
}

vector<int> solution(int n, vector<vector<int>> edges){
    N=(int)edges.size();
    node= n;
    edge= edges;
    vector<int> list;
    get(0,list);

    return ans;
}
*/