# SWEA Problem Solving Repository

> **- NOTICE -**
> *This repository contains my personal solutions for SW Expert Academy problems.*  
> **For study and practice purposes only (비상업적 용도).**
>
> **- 안내 -**  
> 이 저장소에는 SWEA의 문제 원문이나 이미지, 테스트 케이스 등 저작권이 있는 자료는 포함되어 있지 않습니다.  
> 문제 번호와 링크만 명시하며, 코드는 본인이 작성한 풀이와 테스트케이스만 포함합니다.

### 파일명 규칙
'문제난이도_문제번호_문제명.파일형식'으로 구성되어있습니다.  
동일 이름의 txt는 테스트케이스입니다.  
```
SWEA-explanation
 └─ java
    ├─ D3_12345_BFS.java
    └─ D3_12345_BFS.txt
```
- **문제 출처 : https://swexpertacademy.com/**
---
코딩테스트 대비 + 실력 향상을 위한 문제 풀이 모음입니다.  

※ 이 저장소에 업로드되는 코드가 완벽한 해답은 아닙니다.  
※ 참고용으로만 활용하시기 바랍니다.  

---
&nbsp;

# Complexity

> Complexity(복잡도)는 시간복잡도와 공간복잡도가 있습니다.  
> - 시간복잡도 : 알고리즘 실행에 필요한 연산의 횟수  
> - 공간복잡도 : 알고리즘 실행에 필요한 메모리의 양  

SWEA에서는 아래와 같이 복잡도 제한사항을 안내하고 있습니다.  
```
· 시간 : 228개 테스트케이스를 합쳐서 C의 경우 20초 / C++의 경우 20초 / Java의 경우 30초 / Python의 경우 30초
· 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
```
다만 메모리의 경우 넉넉하게 제공되는 편이므로  
복잡도로 Fail이 나오는 경우 시간복잡도에서 초과되는 경우가 많습니다.  

```
복잡도는 절대적이지 않습니다.
예를들어 
```
&nbsp;

# Core Algorithms

> SW역량 테스트의 경우  
> 1. 적정 알고리즘 사용  
> 2. 문제 해결 사고력  
> 3. 유연한 대응  
> 
> 이 세가지가 중요하다고 생각합니다.
> 알고리즘을 익히고 문제를 풀어보시는 것을 추천드립니다.
>
> ※ 주어진 문제를 이해하고 알고리즘이 필요 없다고 판단되면 본인의 생각대로 푸시면 더 간단히 풀리는 문제도 있습니다.

### 1. 완전탐색 (Brute Force)
주어진 문제에서 **'가능한 모든 경우의 수'** 를 요구하는 경우 생각해보면 좋습니다.  
> 반복문이나 조건문 등 기본함수를 사용해 구현할 수 있지만  
> 경우의 수(처리 데이터량)이 많아질수록 실행시간과 메모리 사용량이 기하급수적으로 증가합니다.  
> 완전탐색의 평균 시간복잡도는 $O(n)$ 또는 $O(n^2)$ 입니다.
> 
> ※ 코드 구조를 잡을때 시간복잡도가 $$O(n^3)$$ 를 초과한다면 다른 알고리즘을 사용하시는게 좋습니다.  
 
순열/조합/부분집합/반복문/중첩반복문을 통해 모든 경우의 수를 탐색할 수 있습니다.  
+백트래킹이나 DFS/BFS를 활용하면 시간복잡도를 줄일 수 있습니다.  

| 유형 | 설명 | 시간복잡도 | SWEA 예시 |
|------|------|-------------|------------|
| **순열 (Permutation)** | n개의 원소를 전부 나열 | **O(n!)** | `최소 이동 거리`, `외판원 순회(TSP)` |
| **조합 (Combination)** | n개 중 r개를 선택 | **O(nCr)** ≈ O(2ⁿ) | `부분집합 합`, `조합으로 만들 수 있는 경우` |
| **부분집합 (Subset)** | 각 원소를 선택 or 비선택 | **O(2ⁿ)** | `부분집합의 합`, `부분집합 나누기 문제` |
| **중첩 반복 완전탐색** | for문으로 모든 경우를 시도 | **O(n²) ~ O(n³)** | `브루트포스 암호`, `부분합`, `쌍 찾기` |
| **순열+백트래킹 (Pruned Permutation)** | 순열 중 불필요한 탐색을 가지치기 | **O(k·n!) (k<1)** | `최적 경로 찾기`, `배열 최소합` |
| **DFS/BFS 완전탐색** | 그래프나 격자 전체 탐색 | **O(V+E)** | `미로 탐색`, `연결 요소 개수`, `단지 번호 붙이기` |

---

### 1.1. 백트래킹 (Backtracking)
- 완전탐색 내에서 '불필요한 경우'를 가지치기(Pruning)하여 탐색량을 줄이는 방식  

### 1.2. BFS/DFS
- BFS (Breadth First Search) : 그래프나 트리에서 한 경로를 끝까지 탐색 후 되돌아가 탐색하는 방식  
- DFS (Depth First Search) : 인접한 노드부터 차례대로 탐색하는 방식  

> 주요 문제) 미로, 섬, 연결 요소  
> 2차원 배열 탐색   
> 그래프·맵 문제 대부분에서 이용 가능  
> 큐/스택 기반 탐색  
> dx, dy 패턴  
> BFS는 deque, DFS는 재귀 이용  
> 방문 여부 관리 (visited 노드 또는 배열)  

### 2. 시뮬레이션, 구현 (Simulation)  
문제에서 '행동'이 주어지고 이를 '시뮬레이션'해야 하는 경우에 생각해보면 좋습니다.  
주어진 규칙을 코드로 작성해야 하고, 설명은 간단해보이지만 생각보다 어렵기 때문에 많이 연습해보시는걸 추천합니다.  

> 주요 문제) 방향 전환, 회전, 로봇 이동, 배열 회전 등  
> 대부분 코딩테스트에서 반드시 출제되는 방식  
> '현재 위치 + 방향'을 상태로 관리  
> 회전, 인덱스 범위, 배열 복사  

### 3. 그리디 (Greedy)  
'최소/최적/구간' 등 선택이 필요한 경우 생각해보면 좋습니다.  
항상 '현재 최적의 해'를 선택해서 결과적으로 전체 최적의 해를 구하는 방식입니다.  

> 주요 문제) 미로, 섬, 연결 요소) 회의실 배정, 동전 거스름돈, 구간 선택, 정렬 응용  
> 항상 '정렬 후 순차 선택' 해야함  

| EX) 거스름돈 최소 갯수 |
|:------:|
```
10원부터 500원까지 동전이 있고 m원을 거슬러줘야 할 때, 동전의 최소 갯수는?  
※ 동전을 최소한으로 쓰려면 최대한 큰 금액으로 m을 감산해야함  
-> 1. 동전 배열을 정렬  
-> 2. 반복문을 통해 가장 큰 금액의 동전부터 연산  
-> 3. 갯수 카운트  
```

### 4. 동적 프로그래밍 (Dynamic Programming : DP)  
주어진 문제를 '나눠서 처리'해야 하는 경우 생각해보면 좋습니다.  

> 주요 문제)  
> 이전 계산 결과를 재사용  
> 반복되는 연산식을 줄이는게 목적

| EX) 피보나치 수열 |
|:------:|
```
n에 대한 피보나치값을 출력?  
※ 피보나치(n!)는 n~1을 모두 더한 값  
-> 반복문 이용 결과를 더함 (2~n+1)  
```

### 5. 그래프 (Graph)  



&nbsp;
# Basic I/O
> Programmers(카카오)나 Codility의 경우 매개변수를 통해 변수가 전달되므로 I/O 객체의 메모리 할당을 신경쓸 필요가 없지만  
> SWEA의 경우 다른 온라인저지 사이트처럼 입출력(Input/Output)에 의해 데이터가 입력되고 출력됩니다.
> 
> 따라서, Scanner 처럼 메모리와 시간적 비용이 많이 드는 라이브러리를 지양하면 I/O에서 이득을 볼 수 있습니다.  
> ※ Scanner와 PrintStream의 경우 BR BW SB에 비해 '3배~10배 가량 느리다'고 알려져 있습니다.  

### BufferedReader & BufferedWritter / StringBuilder
| class | BufferedReader | BufferedWritter | StringBuilder | StringTokenizer |
|--------|----------------|-----------------|---------------|-----------------|
| lib | java.io | java.io | 기본패키지 | java.util |
| use | 파일입력 | 파일출력 | 문자열누적(한번에출력) | 입력데이터 파싱 |
| func | 빠른 입력 버퍼 | 빠른 출력 버퍼 | 문자열 조작(결합/수정/삭제 | 문자열 분리(토큰화) |
| method | read(), readLine() 등 | write(), flush() 등 | append(), toString() 등 | hasMoreTokens(), nextToken() 등 |

---

### 1. BufferedReader
표준입력에서 문자열 또는 문자를 추출하기 위해 사용합니다. (Scanner 대체)  

주요 메서드
1. read() : 한글자단위로 읽음    
2. readLine() : 한줄단위로 읽음  

|  | read() | readLine() |
|:---:|:---:|:---:|
| 동작방식 | 한글자 가져옴 | 한줄 가져옴 |
| 개행문자 | 개행문자도 가져옴 | 개행문자는 빼고 가져옴 |
| 반환형 | ASCII로 읽어 int 반환 | String 반환 |
| 종료문자 | null을 만나면 -1 반환 | null을 만나면 -1 반환 |

```java
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
// io.*로 임포트해도 차이 없으니 * 사용하셔도 됩니다. (실제 개발시엔 개별 임포트 추천)

System.setIn(new FileInputStream("res/input.txt"));  
/* IDE 컴파일용 - 실제 풀이에서는 표준입력이 TestCase로 설정되어있기 때문에
SetIn 지정문은 지워주셔야 정상동작합니다.  
txt 내에 "This is SWEA"가 들어있다고 가정 */

BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // br 객체 생성
br.readLine(); // 줄단위 -> "This is SWEA" 가 String으로 반환
br.read(); // 글자단위 -> null -> -1 을 int로 반환 (위에서 첫줄을 읽었으므로 EOF반환)

br.close(); // 객체 종료
```

### 2. BufferedWritter  
문자열을 출력하기 위해 사용합니다. (PrintStream 대체)  

※ 내부 버퍼가 가득 차면 자동으로 flush되고 버퍼를 비운 후 다시 누적  
※ 버퍼 크기 : 8192 character = 2byte * 8192 = 16kb  

주요 메서드  
1. write() : 내부 버퍼에 내용을 누적  
2. flush() : 누적된 문자열을 출력  

```java
import java.io.BufferedWritter;
import java.io.OutputStreamWritter;

BufferedWritter bw = new BufferedWritter(new OutputStreamWritter(System.out)); // bw 객체 생성

for(int test_case = 1; test_case <= T; test_case++) {
 ~테스트케이스 입력 및 반복문 처리~
 bw.write("#" + test_case + " " + simulate + "\n"); // bw에 누적
}
bw.flush(); // 최종 bw 내용 출력
bw.close(); // flush 후 객체 종료
```
