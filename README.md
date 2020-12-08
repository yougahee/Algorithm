# BackJoon Algorithm Repository

:point_right: Purpose : Ready for coding test  :fire:   
:point_right: Goal : I try to solve the algorithm one per day   
:point_right: date : 2020.02.07 ~ ing

<br/>

## Simulation
#### What is Simulation?
- 구현 그 자체의 문제이다.
- 문제에서 요구하는 조건을 충족하고 문제에서 하라는 대로 구현하는 구현 그 자체!

#### Solved Problem
- [Simulation Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Simulation)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 14503 | G5 | 201130 | :o: |  
| 2659 | S4 | 201201 | :o: |  
| 1337 | S4 | 201204 | :o: |  

<br/>

## Brute Force
#### What is Brute Force?
- Brute + Force 로 모든 경우의 수를 고려하고 다 해보는 방법이다.
- 어떻게 보면 무척 쉬운문제가 될 수도 있지만 구현과 예외가 많이 나타나는 문제라면 어려울 수도 있는 알고리즘
- 완전탐색의 일종이다. 

#### Solved Problem
- [Brute Force Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Brute_Force)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1436 | S5 | 201130 | :o: |
| 1107 | G5 | 201202 | :o: |

<br/>

## BFS & DFS
#### What is BFS?
- 너비우선탐색
- Queue를 활용해서 문제해결

#### Solved Problem
[BFS Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/BFS)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 11559 | G5 | 201201 | :o: |
| 2660 | G5 | 201201 | :o: |


#### What is the DFS?
- 깊이우선탐색

#### Solved Problem
[DFS Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/DFS)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |


<br/>

## BackTracking

#### Solved Problem
[BackTracking Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/BackTracking)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |


<br/>

## Recursion
#### What is the Recursion?
- 재귀함수로, 자기자신을 호출하여 값을 도출하는 방법이다.
- 종료조건을 꼭 설정해야하며 StackOverFlow를 조심해야한다.

#### Solved Problem
[Recursion Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Recursion)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 15650 | S3 | 201203 | :o: |


<br/>

## Combination & Permutation
#### Solved Problem
[Combination Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Combination)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |



<br/>

## Permutation
#### Solved Problem
[Permutation Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |


<br/>

## Greedy

#### Solved Problem
[Greedy Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Greedy)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |

<br/>

## DP
#### What is DP?
- Dynamic Programming의 약자로 DP라고 부른다.
- 점화식을 찾는 문제로 문제를 봤을 때 DP라고 감을 잡기도 어려울 뿐더러, 그 규칙을 담아 내고 있는 식을 도출하기까지 시간이 꽤 걸리는 문제다.
- 문제를 푸는 과정에서 시간이 오래걸리지만, 구현은 상대적으로 쉽다. 
- memorization기법으로 배열에 저장하면서 값들을 저장하는 방식으로 문제를 풀어나간다.
- 문제를 풀면 풀수록 내가 과연 이 유형을 알고 있는건가 의문이 든다.

#### Things to watch out for
1. dp를 풀면서 런타임이 나지 않는지 항상 신경써야 한다. ( 요즘 문제를 풀다가 런타임이 나는 경우가 많았다. )
    - 런타임이 나지 않게 하려면, dp를 크기를 입력값으로 하지말고 문제에서 제시한 최대 size로 만들어주자!
    - ex) dp[1] =1, dp[2] = 1 이 있는 경우, n=1로 입력이 들어온다면 dp[1], dp[2] 에 접근하지 못해서 런타임에러가 난다.
2. dp안에 들어가는 값이 int값인지 long 인지 확인 해야한다. 
    - 최대로 들어갈 수 있는 값으로 테스트 해본 후 원하는 값을 출력하는 지 확인하자.
    - 제발 꼭 확인하자! ( 이 부분에서 너무 많이 틀린다ㅠㅠ)


#### Solved Problem
[DP Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/DP)

| Number | level |  date | Solved |  
| :----: | :------: | :----------------------: | :----: |   
| 2579 | S3 | 201203 | :x: |
| 9461 | S3 | 201203 | :x: |
| 1890 | S2 | 201208 | :o: |


<br/>

## Binary Search

#### Solved Problem
[Binary Search Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/BinarySearch)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |



<br/>

## Parametric Search

#### Solved Problem
[Parametric Search Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Parametric_Search)

| Number | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |



<br/>

## Stack
#### What is Stack?
- FILO(First In Last Out)

#### 언제 Stack이 쓰이는가?
- 문제를 풀다보면 어떤 것에 대한 짝을 맞추는 문제 ( ex. 괄호의 짝이 알맞게 맞춰져있는지 ) 등 stack의
특성을 사용하는 문제들에 주로 쓰인다.

#### Solve Problem
- [Stack Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Stack)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 4949 | S4 | 201130 | :o: |


<br/>


## Queue
#### What is Queue?
- 선입선출 ( Fist-In-First-Out)
- 단독으로 queue만 구현해서 문제를 푸는 방식은 거의 나오지 않고 BFS, 그리디 등 여러 알고리즘과 섞여서 나온다.

#### Solve Problem
- [Queue Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Queue)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 19366 | S3 | 201127 | :o: |

<br/>


## Priority Queue
#### What is Priority Queue?
- 우선순위 큐라고 하며 힙이라는 자료구조를 사용한다. 
- 큐의 형태를 가지고 있지만, 우선순위에 맞춰 자동으로? 순위가 매겨져서 저장되어지는 공간이라고 생각하면 된다.
- 힙에는 최대힙, 최소힙이 존재하는데, 일반적인 PQ를 구현한다면, 최소힙이 구현되고 reverseOrder을 해주면 최대힙을 구현할 수 있다. 

#### How can it be applied?
- 우선순위 큐는 혼자 사용하는 경우도 존재하긴 하지만, 그래프 문제를 풀 때 가끔 사용되었던 것으로 기억한다.
- 최소힙과 최대힙을 같이 사용해서 푸는 문제도 존재한다.

#### Solve Problem
- [Priority Queue Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/PriorityQueue)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1655 | G2 | 201202 | :o: |

<br/>


## Graph

## Dijkstra

#### What is Dijkstra?
- Dijkstra Algorithm is All pairs shortest path problem.   
- It is an algorithm for finding the shortest paths between nodes in a graph
- If you want to use Dijkstra Algorithm, you have to know the start, end node.
- If you are implemented the Dijkstra Algorithm, you need to use 1-dimensional array and initial Big value.  
- 이것은 DP의 종류라고 한다. ( 그 이유는, 사용한 dist의 거리를 )

#### How 
- Priority Queue 사용
- Visited 배열 ( 방문한 노드를 꼭 다시 방문하지 않도록 처리해주어야 한다. )

#### Solve Problem
- [Dijkstra Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Dijkstra)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1753 | G5 | 201205 | :o: |
| 1504 | G4 | 201207 | :o: |


<br/>

## Floyd Warshall

#### Solve Problem
- [Floyd Warshall Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Floyd_Warshall)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1613 | G3 | 201124 | :o: |


<br/>

## Bellman-Ford 

#### Solve Problem
- [Bellman-Ford Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Dijkstra)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
|  |  |  |  |


<br/>


## Topological Sort
#### What is Topological Sort?
- This Algorithm is sorting directional graph's node.

#### How do you sort it?
- You may count the node that visited

#### When do you use it?
- DAG(directed acyclic graph) -> directed and acyclic (사이클이 없다.)
- 그래프에서 반드시 자신보다 선행되어야 할 일을 다 끝내야만 작업에 들어갈 수 있는(방문할 수 있는) 조건이 주어질 때
- 전후관계가 분명하다면 위상정렬을 사용해야한다.
  
#### Characteristic
- There can be multiple results of this algorithm. ( Queue's size is over 1)

#### Solve Problem
- [Topological Sort Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Topological_Sort)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1005 | G3 | 201124 | :o: |
| 1516 | G3 | 201123 | :o: |
| 2623 | G2 | 201123 | :o: |

<br/>

## Union-Find
#### What is Union-Find

#### Solve Problem
- [Union-Find Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Union_Find)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 1717 | G4 | 201126 | :o: |

<br/>

## Tree

#### Characteristic
- 무방향, 방향이 있는 트리가 있다.
- 무방향인 경우, 간선*2 = 정점-1
- 방향이 있는 트리인 경우, 간선의 수 = 정점 -1
- 트리에는 순환, 사이클이 존재하면 안된다. ( 셀프사이클도 안됨. )


#### Solve Problem
- [Tree Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Tree)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 4256 | G5 | 201205 | :o: |
| 4803 | G4 | 201206 | :x: |




## Minimum Spanning Tree (MST)

#### What is the Minimum Spanning Tree?
- 트리의 간선에 가중치(cost)가 있을 때, 간선의 가중치 합이 최소인 스패닝 트리

#### Solve Problem
- [Minimum Spanning Tree Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/Tree)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |



<br/>

## Segment Tree

#### What is the Segment Tree?
- 구간을 보존하고 있는 트리
- 재귀를 활용하여 문제를 풀 수 있다.


#### Solve Problem
- [Segment Tree Problem Link](https://github.com/yougahee/algorithm-boj/tree/master/Algorithm/SegmentTree)

| 문제번호 | level |  date | Solved |
| :----: | :------: | :----------------------: | :----: |
| 2042 | G1 | 201203 | :o: |




