# SWEA Problem Solving Repository

> **- NOTICE -**
> *This repository contains my personal solutions for SW Expert Academy problems.*  
> **For study and practice purposes only (비상업적 용도).**
>
> **- 안내 -**  
> 이 저장소에는 SWEA의 문제 원문이나 이미지, 테스트 케이스 등 저작권이 있는 자료는 포함되어 있지 않습니다.  
> 문제 번호와 링크만 명시하며, 코드는 본인이 작성한 풀이와 테스트케이스만 포함합니다.

### 파일명 규칙
`문제난이도_문제번호_문제명.파일형식` 으로 구성되어있습니다.  
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

# 복잡도 (Complexity)

> 복잡도는 시간복잡도와 공간복잡도가 있습니다.  
> - 시간복잡도 : 알고리즘 실행에 필요한 연산의 횟수  
> - 공간복잡도 : 알고리즘 실행에 필요한 메모리의 양  

SWEA에서는 아래와 같이 복잡도 제한사항을 안내하고 있습니다.  
```
· 시간 : 228개 테스트케이스를 합쳐서 C의 경우 20초 / C++의 경우 20초 / Java의 경우 30초 / Python의 경우 30초
· 메모리 : 힙, 정적 메모리 합쳐서 256MB 이내, 스택 메모리 1MB 이내
```
다만 메모리의 경우 넉넉하게 제공되는 편이므로  
복잡도로 Fail이 나오는 경우 시간복잡도에서 초과되는 경우가 많습니다.  

> 문제를 확인할 때 데이터 개수와 시간제한을 통해 대략적인 시간복잡도 구성(효율적인 알고리즘)을 정할 수 있습니다.  
> 입력 100 이하 : O(n³) : 3중 for 가능  
> 입력 1,000 이하 : O(n²) : 2중 for 가능, BFS/DFS/그래프  
> 입력 100,000 이상 : O(n log n) 이하 : 정렬/힙/세그먼트트리  
> 입력 1,000,000 이상 : O(n) 또는 O(log n) : 누적합/슬라이딩윈도우  
> 
> 하지만 복잡도는 절대적이지 않습니다.  
> 예를들어 연산횟수가 3n³ + 5n² + 100만인 경우 빅오 표기에선 항상 O(n³)으로 표기하지만,  
> n=10 : 1,003,500  
> n=10,000 : 4,500,000  
> 이와같이 데이터 n이 작다면 +100만이 미치는 영향이 매우 커지게 됩니다.  
> 
> 따라서 본인이 문제를 확인하고 맞다고 생각되는 방식으로 구현하되,  
> 복잡도가 높아지는 경우 알고리즘을 교체해보는 방법이 가장 좋습니다.  

&nbsp;

# 자주 사용되는 연산식
### 01. 홀수/짝수 판별
```java
// 산술연산 활용
n % 2 != 0 // 홀수
n % 2 == 0 // 짝수
// 비트연산 활용
n & 1 == 1 // 홀수
n & 1 == 0 // 짝수
```
### 02. 2의 거듭제곱 판별
```java
// 산술연산 활용
n % 2 == 0 // 2의 거듭제곱
// 비트연산 활용
n & (n - 1) == 0 // 2의 거듭제곱

// n에 대한 k의 거듭제곱 판별
while(n % k == 0) n /= k
```

&nbsp;

# 라이브러리 메서드
### 01. String (문자열)
기본라이브러리  

| 메서드 | 해석 | 반환형 |
|---|---|---|
| s.length(); | 길이 ("abc" -> 3) | int |
| s.charAt(i); | i번째 문자 ("abcdef" -> 2 -> 'c') | char |
| substring(from, to); | from이상 to미만 부분문자열 | String |
| s.split("정규식") | 정규식을 기준으로 분리 | String[] |
| trim() | 앞뒤 공백제거 | String |
| replace(a, b) | a를 전부 b로 치환 | String |
| indexOf(str) | str이 발견되는 위치 확인 | int |
| contains(str) | str이 있는지 확인 | boolean |
| toCharArray() | str을 어레이로 변경 | char[] |

---

### 02. Math
import java.lang.Math;  

| 메서드 | 해석 | 반환형 |
|---|---|---|
| Math.max(a, b); | a,b 중 큰값 | 입력형과 동일 |
| Math.min(a, b); | a,b 중 작은값 | 입력형과 동일 |
| Math.abs(x); | x의 절대값 | 입력형과 동일 |
| Math.pow(a, b); | a의 b제곱 (거듭제곱) | double |
| Math.sqrt(x); | x의 제곱근 | double |
| Math.ceil(x); | 올림 | double |
| Math.floor(x); | 내림 | double |
| Math.round(x) | 반올림 | int, long |

---

### 03. Number / Character (숫자/문자)
기본 라이브러리  

| 메서드 | 해석 | 반환형 |
|---|---|---|
| Integer.parseInt(s) | s를 int로 파싱 | int |
| Long.parseLong(s) | s를 long으로 파싱 | long |
| Integer.parseInt(s, base) | s를 base진법으로 변환 | int |
| Character.isDigit(c) | c가 숫자형이면 true | boolean |
| Character.isUpperCase(c) | c가 대문자면 true | boolean |
| Character.isLowerCase(c) | c가 소문자면 true | boolean |
| .toUpperCase(c or s) | c나 s를 대문자로 변환 | char, String |
| .toLowerCase(c or s) | c나 s를 소문자로 변환 | char, String |

---

### 04. Arrays (배열)
import java.util.Arrays;  

| 메서드 | 해석 | 반환형 |
|---|---|---|
| Arrays.sort(arr) | arr 배열 정렬 (오름차순) | |
| Arrays.fill(arr, v) | arr 배열을 v로 채우기 | |
| Arrays.toString(arr) | arr 배열을 String으로 변환 | String |

---

### 05. Collections / List
기본 개념  
인터페이스에 구현체를 담아 생성  
구현체는 ArrayList, LinkedList  

List<자료형> 변수명 = new ArrayList<>();  
List<자료형> 변수명 = new LinkedList<>();  
ArrayList<자료형> 변수명 = new ArrayList<>();  
```java
import java.util.ArrayList;

ArrayList<Integer> arrayList = new ArrayList<>(); // 리스트 { 1, 5, 10 }
ArrayList<Integer[]> arrayList = new ArrayList<>(); // 배열 리스트 { [1,2], [3,4], [7,8,9] }
ArrayList<List<Integer>> arrayList = new ArrayList<>(); // 리스트 내 리스트
ArrayList<Node> arrayList = new ArrayList<>(); // 구조체(클래스) 리스트
```

| 메서드 | 해석 |
|---|---|
| add(x) | 리스트에 x 삽입 |
| get(i) | i번째 데이터 로드 |
| set(i, x) | i번째 데이터에 x 삽입 |
| remove(i) | i번째 데이터 삭제 |
| size() | 리스트 크기 확인 |
| clear() | 리스트 초기화 |
| Collections.sort(list) | 정렬 (오름차순) |
| Collections.sort(list,reverseOrder()) | 정렬 (내림차순) |

---

### 06. Queue(큐) / Stack(스택) / Deque(덱)
기본 개념  
인터페이스에 구현체를 담아 생성  
> 즉, 인터페이스 = new 구현체; 방식으로 생성되고  
> 구현체로는 LinkedList, Stack, ArrayDeque가 있음  
> LinkedList : 포인터 구조 - 상대적으로 메모리 소모가 크고 시간이 느림  
> Stack : 동기화 오버헤드로 시간이 느림  
> ArrayDeque : 중간삽입/삭제 불가능, null값 사용불가  

| 이름 | 구조 | 특징 | 사용예시 |
|:---:|:---:|---|---|
| **Queue** | FIFO | 선입선출 | BFS, 작업 대기열, 시뮬레이션 등 |
| **Deque** | DEQ | 앞뒤로 입출력 (스택 대체) | 슬라이딩 윈도우, 0-1 BFS, 회전 큐 |
| **Stack** | LIFO | 후입선출 | 괄호 검사, DFS, 되돌리기(undo), 수식 계산 |

공통 메서드  
| 메서드 | 해석 |
|---|---|
| .isEmpty(); | 비었는지 확인 |
| .size(); | 크기 확인 |
| .clear(); | 초기화 |
| .contains(x); | x 포함여부 확인 |

### 6.1. Queue (큐)
선입선출식 자료구조  
Queue<자료형> 변수명 = new LinkedList<>();   
Queue<자료형> 변수명 = new ArrayDeque<>(); -> 구현체를 ArrayDeque로 하면 성능상 이점이 더 많음
```java
import java.util.Queue;
import java.util.LinkedList;

Queue<Integer> q = new LinkedList<>();
```
| 메서드 | 해석 |
|---|---|
| q.offer(x); | 뒤에 추가 |
| q.poll(); | 앞에서 꺼내고 제거 |
| q.peek(); | 앞 값 확인 |

### 6.2. Stack (스택)
후입선출식 자료구조  
Stack<자료형> 변수명 = new Stack<>();
```java
import java.util.Stack;

Stack<Integer> st = new Stack<>();
```
| 메서드 | 해석 |
|---|---|
| push(x) | 뒤에 추가 |
| pop() | 앞에서 꺼내고 제거 |
| peek() | 앞 값 확인 |
| empty() | 비었으면 true |
| search(x) | 위에서부터 1-base index, 없으면 -1 |

### 6.3. Deque (덱)
양쪽으로 자료 입출력이 가능한 자료구조  
Queue와 Stack의 동작을 모두 Deque에서 구현할 수 있으므로 제일 추천됨  
Deque<자료형> 변수명 = new ArrayDeque<>();  
```java
import java.util.Deque;
import java.util.ArrayDeque;

Deque<Integer> dq = new ArrayDeque<>();
```
| 메서드 | 해석 |
|---|---|
| dq.addLast(x); | 뒤에 추가 |
| dq.addFirst(x); | 앞에 추가 |
| dq.pollFirst(); | 앞에서 꺼내고 제거 |
| dq.pollLast(); | 뒤에서 꺼내고 제거 |
| dq.peekFirst(); | 앞 값 확인 |
| dq.peekLast(); | 뒤 값 확인 |
| dq.push(x); | 뒤에 추가 |
| dq.pop(); | 앞에서 꺼내고 제거 |
| dq.peek(); | 앞 값 확인 |

---

### 07. Map / Set

| 자료구조 | 저장 형태 | 중복 | 자료 순서 |
|:---:|---|:---:|:---:|
| **Set** |값(value)만 | X | X |
| **Map** | (Key, Value) 매핑 | Key만 중복 X | X |

### 7.1. Set
중복없이 값을 저장할때 사용  
Set<자료형> 변수명 = new HashSet<>();  
```java
import java.util.Set;
import java.util.HashSet;

Set<Integer> set = new HashSet<>();
set.add(10);
set.add(20);
set.add(10); // 중복불가로 입력 X
```
| 메서드 | 해석 |
|---|---|
| add(x) | x 추가 |
| remove(x) | x 제거 |
| contains(x) | x 포함 여부 |
| size() | 크기(원소 개수) 확인 |
| isEmpty() | 비었는지 확인 |
| clear() | 초기화 |

### 7.2. Map
중복없이 값을 저장할때 사용  
Map<자료형, 자료형> 변수명 = new HashMap<>();  
```java
import java.util.Map;
import java.util.HashMap;

Map<String, Integer> map = new HashMap<>();
map.put("apple", 3);
map.put("banana", 5);
map.put("apple", 10); // 키 중복으로 기존 밸류에 덮어씌워짐
```
| 메서드 | 해석 |
|---|---|
| put(k, v) | 키-밸류 쌍 저장 |
| get(k) | k키의 밸류 |
| getOrDefault(k, default) | k키가 없을 경우 default 반환 |
| containsKey(k) | k키 존재 여부 |
| remove(k) | k키 데이터 삭제 |
| keySet() | key 리스팅 |
| values() | value 리스팅 |
| entrySet() | key-value 전체 리스팅 |

---

&nbsp;

# 주요 알고리즘 (Core Algorithms)

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
 
### 1.1. BFS/DFS
- BFS (Breadth First Search) : 그래프나 트리에서 한 경로를 끝까지 탐색 후 되돌아가 탐색하는 방식  
[ 현재 상태 확인 → 다음 상태 삽입 → 다음 상태 확인 ] 반복
- DFS (Depth First Search) : 인접한 노드부터 차례대로 탐색하는 방식  
[ 현재 상태 선택 → 다음 상태 진입 → 더이상 진입할 수 없으면 복귀 ] 반복 

| EX) 미로 길찾기 (BFS) |
|---|
```java
5
01112
00000
11011
00000
11013
/* 첫행 N은 NxN 행렬임을 나타냄
2에서 시작해 3으로 끝나는 최단루트 */
static int N; // 너비,높이
static int[][] map; // 미로
static int[][] distance; // 거리측정
static boolean[][] visited; // 방분여부

int[] defRow = {-1, 1, 0, 0}; // X좌표(좌우)
int[] defCol = {0, 0, -1, 1}; // Y좌표(상하)

bfs(stAxisX, stAxisY);

static boolean bfs(int sRow, int sCol) {
 Queue<int[]> q = new LinkedList<>(); // FIFO를 위해 큐 생성

 visited[sRow][sCol] = true; // 방문처리
 dist[sRow][sCol] = 1;   // 시작 칸도 거리 1로 카운트
 q.offer(new int[]{sRow, sCol}); // 큐에 시작좌표 입력

 while (!q.isEmpty()) { // 큐가 빌때까지 반복
  int[] now = q.poll(); // 큐에서 좌표 꺼냄
  int nowRow = now[0];
  int nowCol = now[1];

  if (map[nowRow][nowCol] == 3) {  // 도착하면 종료
   return true;
  }

  for (int d = 0; d < 4; d++) { // 상하좌우로 이동
   int nRow = row + defRow[d]; // X좌표
   int nCol = col + defCol[d]; // Y좌표

   if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue; // 미로 범위 밖이면 다음위치 확인
   if (map[nRow][nCol] == 1) continue; // 벽(1)이면 다음위치 확인
   if (visited[nRow][nCol]) continue; // 방문한 위치면 다음위치 확인

   visited[nr][nc] = true; // 해당 칸 방문처리
   dist[nr][nc] = dist[r][c] + 1; // 해당 칸에 이동거리 + 1
   q.offer(new int[]{nr, nc}); // 큐에 새 좌표 삽입
  }
 }
 return false;
}

```

| EX) 지도 내 섬 갯수 (DFS) |
|---|

![DFSIslandEX1](https://github.com/SamakFOX/SWEA-explanation/blob/main/exampleImages/DFSIslandEX1.png)
```java
7 7
0 0 0 0 1 1 0
1 1 0 1 1 1 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
1 1 0 0 0 0 0
1 1 0 1 1 1 1
1 0 0 0 1 0 0

// 섬은 네모로 보며, 대각선으로 닿은 경우 별개의 섬으로 간주 -> 5개

boolean[][] visited; // 방문여부 체크용 배열
// 순차방문이 아닐때 사용, 무조건 순차방문일땐 안써도 반복문으로 처리 가능

int[] defRow = {-1, 1, 0, 0}; // X좌표(좌우)
int[] defCol = {0, 0, -1, 1}; // Y좌표(상하)
/* 대각선도 붙은 섬으로 볼땐
defRow = {-1, -1, -1, 0, 0, 1, 1, 1};
defCol = {-1, 0, 1, -1, 1, -1, 0, 1};
후에 XY좌표 탐색 시 d < 8로 탐색 */

if (map[r][c] == 1 && !visited[r][c]) {
 dfs(r, c); // 현재 구역 전체 탐색
 count++;   // 섬 갯수 증가
}

dfs(int row, int col) {
 visited[row][col] = true; // 방문처리

 for (int d = 0; d < 4; d++) {
  int nRow = row + defRow[d]; // X좌표
  int nCol = col + defCol[d]; // Y좌표

  if (nRow < 0 || nRow >= N || nCol < 0 || nCol >= M) continue; // 지도 범위 밖이면 다음위치 확인
  if (map[nRow][nCol] != 1) continue; // 섬이 아닌곳(0)이면 다음위치 확인
  if (visited[nRow][nCol]) continue; // 방문한 위치면 다음위치 확인

  dfs(nRow, nCol); // XY좌표로 DFS 재귀호출
  }
}
```

> 주요 문제) 미로, 섬, 연결 요소  
>  
> 2차원 배열 탐색  
> 그래프·맵 문제 대부분에서 이용 가능  
> '최단경로' 요구 시 BFS 추천 (DFS는 최단경로 보장하지 않음)  
> 큐/스택 기반 탐색  
> dx, dy 패턴  
> BFS는 deque, DFS는 재귀 이용  
> 방문 여부 관리 (visited 노드 또는 배열)  

### 1.2. 백트래킹 (Backtracking)
- 완전탐색 내에서 '불필요한 경우'를 가지치기(Pruning)하여 탐색량을 줄이는 방식  
- DFS로 모든 경우의 수를 끝까지 들어가며 선택/변경 후 돌아올 때 원상복구하며 불필요 경우의 수를 차단하는 방식

| EX) 보호필름 성능테스트 (DFS+백트래킹) |
|---|

[![코드 확인](https://img.shields.io/badge/코드_확인-blue?style=for-the-badge)](https://github.com/SamakFOX/SWEA-explanation/blob/main/java/MOCK_2112_filmPT.java)  
https://github.com/SamakFOX/SWEA-explanation/blob/main/java/MOCK_2112_filmPT.java  

---

### 2. 시뮬레이션, 구현 (Simulation)  
문제에서 '행동'이 주어지고 이를 '시뮬레이션'해야 하는 경우에 생각해보면 좋습니다.  
주어진 규칙을 코드로 작성해야 하고, 설명은 간단해보이지만 생각보다 어렵기 때문에 많이 연습해보시는걸 추천합니다.  

> 주요 문제) 방향 전환, 회전, 로봇 이동, 배열 회전 등  
> 
> 대부분 코딩테스트에서 반드시 출제되는 방식  
> '현재 위치 + 방향'을 상태로 관리  
> 회전, 인덱스 범위, 배열 복사

| EX) 역방향 사다리게임 |
|---|
```
100x100 크기의 사다리게임의 당첨자를 미리 알 수 있는 방법
※ 도착지 정보를 통해 되돌아가며 좌우로 '사다리타기'를 시뮬레이션
-> 1. 마지막위치 확인
-> 2. 위로 올라가며 사다리가 연결되었는지 확인
-> 3. 연결된 방향으로 이동
-> 4. 출발점에 도착하면 최종 위치 출력
```

[![코드 확인](https://img.shields.io/badge/코드_확인-blue?style=for-the-badge)](https://github.com/SamakFOX/SWEA-explanation/blob/main/java/D4_1210_ladder1.java)  
https://github.com/SamakFOX/SWEA-explanation/blob/main/java/D4_1210_ladder1.java  
* 해당 코드에선 사다리 좌우이동 시간을 줄여 빠르게 구현하려 하였으나  
정석대로 1을 계속 따라가도록 구현하면 코드가 더 줄어들 수 있습니다.
---

### 3. 그리디 (Greedy)  
'최소/최적/구간' 등 선택이 필요한 경우 생각해보면 좋습니다.  
항상 '현재 최적의 해'를 선택해서 결과적으로 전체 최적의 해를 구하는 방식입니다.  

> 주요 문제) 회의실 배정, 동전 거스름돈, 구간 선택, 정렬 응용  
> 
> 항상 '정렬 후 순차 선택' 해야함  

| EX) 거스름돈 최소 갯수 |
|---|
```
10원부터 500원까지 동전이 있고 m원을 거슬러줘야 할 때, 동전의 최소 갯수는?  
※ 동전을 최소한으로 쓰려면 최대한 큰 금액으로 m을 감산해야함  
-> 1. 동전 배열을 정렬  
-> 2. 반복문을 통해 가장 큰 금액의 동전부터 연산  
-> 3. 갯수 카운트  
```
---

### 4. 동적 프로그래밍 (Dynamic Programming : DP)  
최적의 해를 구하기에 시간과 메모리가 매우 많이 필요한 문제를 해결하기 위해 사용합니다.  
주어진 문제를 '나눠서 처리'해야 하는 경우 생각해보면 좋습니다.  

> 주요 문제)  
> 
> 이전 계산 결과를 재사용  
> 반복되는 연산식을 줄이는게 목적  

| EX) 피보나치 수열 |
|---|
```
n에 대한 피보나치값을 출력?  
※ 피보나치(n!)는 n~1을 모두 더한 값  
-> 반복문 이용 결과를 더함 (2~n+1)
```

### 4.1. 메모이제이션 (Top-Down)
> 큰 문제에서 시작해 재귀적으로 작은문제 레벨로 내려간 후 계산  
> 재귀호출 이용  
> 필요 부분만 계산  
> ! 상황에 따라 Stack Overflow 가능성 있음  

### 4.2. 타뷸레이션 (Bottom-Up)
> 작은 문제부터 순차적으로 계산  
> 주로 반복문 이용  
> 전체 구간 모두 계산  

---

### 5. 그래프 (Graph)  

다익스트라 / 벨만포드 / 플로이드 워셜 알고리즘은 최단경로 알고리즘이라고도 합니다.  
최단경로 문제는 보통 그래프를 이용해 표현되며, 정점은 '노드'로 연결선은 '간선'으로 표현됩니다.  


### 5.1. 다익스트라 (Dijkstra)
그래프에서 한 정점(시작점)으로부터 모든 정점까지의 최단 거리를 구하기 위해 사용합니다.   
단, 간선 가중치가 모두 양수일 때만 사용 가능합니다.  
매번 '가장 가중치가 적은 노드'를 선택하는 과정의 반복이므로 그리디 알고리즘으로 분류되기도 합니다.  

> **알고리즘 원리**  
> 1. 출발 노드 설정  
> 2. 최단 거리 테이블 초기화 (시작 노드까지의 거리는 0, 나머지는 무한으로 설정 int:1e9)  
> 3. 미방문 노드 중 가장 가까운 노드를 선택  
> 4. 해당노드를 거쳐 다른 노드로 가는 비용 계산  
> 5. 더 짧은 경로를 찾으면 최단거리 테이블 갱신  
> 6. 3~5 과정 반복
> 
> 리스트(ArrayList) 사용 : 최단거리 관리  
> 우선순위 큐(PriorityQueue) 사용 : 각 노드의 정점과 간선을 큐에서 관리  
> -> 가장 우선순위가 높은 데이터가 먼저 추출  

| EX) A-F 최단거리 |
|---|
 
![DijkstraEX1](https://github.com/SamakFOX/SWEA-explanation/blob/main/exampleImages/DijkstraEX1.png)

| 노드 | 초기 | A선택 | D선택 | B선택 | E선택 | C선택 | F선택 |
|:---:|:---:|:---:|:---:|:---:|:---:|:---:|:---:|
| A | 0 | 0 | 0 | 0 | 0 | 0 | 0 |
| B | ∞ | 2 | 2 | 2 | 2 | 2 | 2 |
| C | ∞ | 5 | 5 | 4(2+2) | 3(2+1) | 3 | 3 |
| D | ∞ | 1 | 1 | 1 | 1 | 1 | 1 |
| E | ∞ | 8 | 2(1+1) | 2 | 2 | 2 | 2 |
| F | ∞ | ∞ | ∞ | ∞ | 4(2+2) | 4 | 4 |

> 최단거리 순서 : A, D, B, E, C, F  
> 최단루트 : A → D → E → F
```java
class Node implements Comparable<Node> {
    int to, cost;
    Node(int to, int cost) {
        this.to = to;
        this.cost = cost;
    }
    // pq.poll() 판단기준 재정의
    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost; 
    }
}

public class Solution {
    static final int INF = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph = new ArrayList<>(); // 인덱싱을 위해 ArrayList 사용
    static int[] dist;

    public static void main(String[] args) throws Exception {
        /* ~ 기본데이터 파싱 생략 ~ */
        // 기본데이터 초기화
        dist = new int[V + 1]; // 노드별 거리(가중치)
        Arrays.fill(dist, INF);
        // 노드 그래프 초기화
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        // 그래프 데이터 파싱
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph.get(from).add(new Node(to, cost));
        }
        // 점화식
        dijkstra(stAxis);
        /* ~ 출력문 생략 ~ */
    }

    static void dijkstra(int stAxis) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        dist[stAxis] = 0;
        parent[stAxis] = 0; // 시작점은 부모 없음 표시
        pq.add(new Node(stAxis, 0));

        while (!pq.isEmpty()) {
            Node cur = pq.poll(); // cost가 적은 노드 꺼냄
            int now = cur.to;
            int nowCost = cur.cost;

            if (dist[now] < nowCost) continue;

            for (Node next : graph.get(now)) {
                int cost = nowCost + next.cost;
                if (cost < dist[next.to]) {
                    dist[next.to] = cost;
                    parent[next.to] = now;
                    pq.add(new Node(next.to, cost));
                }
            }
        }
    }
}
```
> compareTo(Node o)의 판단기준  
> poll을 호출하면 호출 전 내부적으로 A.compareTo(C), D.compareTo(A) ··· 과정이 진행되는데  
> 이 때 A.compareTo(C) 라면 A가 this, C가 o가 됨  
> 반환값은 음수, 0, 양수 3가지중 하나  
> return이 음수면 this가 우선, 0이면 동일순위, 양수면 o가 우선  
> 
> this.cost - o.cost; // cost 작은 순서  
> 매 판단 시 <현재cost - 비교cost> this가 더 크다면 음수가 됨 ex) this=5, o=10, 5-10=-5  
> o.cost - this.cost; // cost 큰 순서  
> 매 판단 시 <비교cost - 현재cost> this가 더 크다면 양수가 됨 ex) this=5, o=10, 10-5=5  

### 5.2. 벨만포드 (Bellman-Ford)
그래프에서 한 정점(시작점)으로부터 모든 정점까지의 최단 거리를 구하기 위해 사용합니다.    
간선 가중치에 음수가 있을 때 사용 가능합니다.  

### 5.3. 플로이드 워셜 (Floyd-Warshall)
모든 지점에서 다른 모든 지점까지의 최단 경로를 모두 구하기 위해 사용합니다.  
노드가 N개일 때 N단계를 수행하게 되며, 단계마다 현재 노드를 거치는 모든 경로를 계산합니다. O(N³)  
이렇게 매 단계마다 2차원리스트를 갱신하기 때문에 다익스트라와 다르게 DP로 분류되기도 합니다.  
코드가 다익스트라에 비해 간결해서 구현은 비교적 쉽지만, 핵심 아이디어를 이해하는 것이 중요합니다.  

> **알고리즘 원리**  
> 1. dist 배열 초기화  
> 2. 3중 for문 이용 최단거리 확장  
> 3. dist[i][j] : i에서 j로 가는 최단 거리  
> 4. 결과 출력  

```java
        // 3. 플로이드–워셜
        for (int k = 1; k <= N; k++) {
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (dist[i][k] == INF || dist[k][j] == INF) continue; // 오버플로 방지
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
```

---

&nbsp;

# Basic I/O
> Programmers(카카오)나 Codility의 경우 매개변수를 통해 변수가 전달되므로 I/O 객체의 메모리 할당을 신경쓸 필요가 없지만  
> SWEA의 경우 다른 온라인저지 사이트처럼 입출력(Input/Output)에 의해 데이터가 입력되고 출력됩니다.
> 
> 따라서, Scanner 처럼 메모리와 시간적 비용이 많이 드는 라이브러리를 지양하면 I/O에서 이득을 볼 수 있습니다.  
> ※ Scanner와 PrintStream의 경우 BR BW SB에 비해 '3배~10배 가량 느리다'고 알려져 있습니다.  

### 주요 I/O 요약
|  | BufferedReader | BufferedWritter | StringBuilder | StringTokenizer |
|:-----:|----------------|-----------------|---------------|-----------------|
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

---
### 2. BufferedWriter  
문자열을 출력하기 위해 사용합니다. (PrintStream 대체)  

※ 내부 버퍼가 가득 차면 자동으로 flush되고 버퍼를 비운 후 다시 누적  
※ 버퍼 크기 : 8192 character = 2byte * 8192 = 16kb  

주요 메서드  
1. write() : 내부 버퍼에 내용을 누적  
2. flush() : 누적된 문자열을 출력  

```java
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;

BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // bw 객체 생성

for(int test_case = 1; test_case <= T; test_case++) {
 ~테스트케이스 입력 및 반복문 처리~
 bw.write("#" + test_case + " " + simulate + "\n"); // bw에 누적
}
bw.flush(); // 최종 bw 내용 출력
bw.close(); // flush 후 객체 종료
```
---

### 3. StringBuilder
문자열 처리를 위해 사용합니다. (결합, 수정, 삭제)  

주요 메서드  
1. append("") : 문자열 결합  
2. toString() : String으로 캐스팅  
3. reverse() : 문자열 뒤집기  
4. insert(n) : 문자열 삽입 (n번 인덱스)  
5. delete(n, m) : 문자열 삭제 (n ~ m-1 인덱스)  
6. deleteCharAt(n) : 문자 삭제 (n번 인덱스)  

```java
//java.lang의 기본클래스이므로 import 불필요

StringBuilder sb = new StringBuilder();
sb.append("This is").append(" SWEA"); // "This is SWEA"
sb.insert(5, "n"); // "This nis SWEA"
sb.replace(0, 4, "That"); // "That nis SWEA"
sb.deleteCharAt(5); // "That is SWEA"
sb.delete(0, 4); // " is SWEA"
sb.reverse(); // "AEWS si "

int len = sb.length(); // 8

sb.append("\n"); // 개행문자 수동입력(자동x)
// 출력형식이 개행이 필요한 경우 '\n' "\n" 상황에 따라 사용

bw.write(sb.toString()); // bw에 누적
```
---

### 4. StringTokenizer
문자열을 분리하기 위해 사용합니다  
기준문자를 기준으로 분리되며, 기준문자 미기입시 기본값(공백)을 기준으로 분리합니다.  

주요 메서드  
1. hasMoreTokens() : 토큰이 남았는지 확인 (boolean)  
2. nextToken() : 다음 토큰 가져오기 (String)  
3. countTokens() : 남은 토큰 수 확인  

```java
import java.util.StringTokenizer;

int T = Integer.parseInt(br.readLine());
for(int test_case = 1; test_case <= T; test_case++) {
 StringTokenizer st = new StringTokenizer(br.readLine());
 // 기본 - 스페이스 기준으로 분리 (A B N 형식인 경우)
 int inA = Integer.parseInt(st.nextToken()); // 토큰의 String을 int로 캐스팅
 int inB = Integer.parseInt(st.nextToken());
 int inN = Integer.parseInt(st.nextToken());

 StringTokenizer st = new StringTokenizer(br.readLine(), ",");
 // 지정 - 구분자(,) 기준으로 분리 (A, B, N 형식인 경우)
 String stA = st.nextToken().trim(); // 쉼표 기준 분리 후 공백도 제거
 String stB = st.nextToken().trim();
 int stN = Integer.parseInt(st.nextToken()); // parseInt는 자동으로 whitespace 제거 후 캐스팅함


 while (st.hasMoreTokens()) {
  int num = Integer.parseInt(st.nextToken());
  // 모든 토큰에 반복작업이 필요한 경우 반복문 활용
 }
}
```

---

### 5. String 라이브러리 이용 (TC파싱)

```java
line = "100100001101100011" // 숫자로만 구성
int num = line.charAt(i) - '0';
// String 라이브러리의 Character 클래스는 ASCII를 이용하기 때문에 '0'(int 48)을 빼줘야 정상 숫자로 사용 가능

line = "ADSFESQIJTIDSLJGKL" // 문자로만 구성
char ch = line.charAt(i);
char[] arr = line.toCharArray();
// 어레이로 전환하는 메서드는 특별히 배열을 추가로 사용해야하는게 아니면 메모리 손해

line = "A01B102C123"
if (ch >= '0' && ch <= '9') {} // 조건분기 추가

line = "A  B\tC D   E"
String[] arr = line.split("\\s+");
// 코테에선 이렇게 정규식 기반으로 파싱할때만 사용

line = "NH)123456-78-901234"
line.replace("NH", "KB"); // 문자열 교체
substring(3); // = substring(3, line.length()) 필요부분만 자르기
// String  = length(), Map/List/Set = size()
```

---

&nbsp;

# 문제 유형 판단

### 01. 게임이론
| 나타나는 특징 |	의미 |
|---|---|
| 두 명이 번갈아 한다	| W / L 게임 구조 |
| 한 턴에 N이 줄어든다 / 돌을 뺀다	| 상태 감소 게임 |
| 못 하면 진다 (실행 불가 시 패배)	| L 상태 정의 |
| 최선을 다한다	| 그리디가 아니라 게임이론 |
| 제한 없이 큰 N	| 시뮬 불가, 패턴 필요 |
| T가 크고 N 범위가 큼 |	빠른 판정 필요 |

| ex) 약수 게임 |
|---|

> 두사람이 번갈아가며 '2 이상 N-1 이하 약수 C'를 고른 뒤, 'N-C'. N의 약수가 존재하지 않을때 패배  
> 변수 N의 초깃값은 1 이상 10¹⁸ 이하의 자연수이다.  
> https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AZlP4WFKvNPHBIO0  
>
> N 범위가 코드만으로 돌아가기 어렵고, 게임적 패턴이 존재 -> 게임이론  
>
> A가 항상 먼저 시작하므로 N이 홀수일때, N이 2의 제곱수이면서 지수가 홀수일때는 무조건 패배하게 됨 (서로 최선의 선택을 한다는 조건)  
>
> 게임이론에서는...  
> W(이기는 상태): 한 번 움직여서 상대에게 Lose를 보낼 수 있는 상태  
> L(지는 상태): 가능한 모든 다음 상태가 Win인 상태  
> 이때, 본인 턴에 Lose인 경우 항상 상대에게 Win을 주게 되며  
> 본인 턴에 Win인 경우 상대에게 Win/Lose 중 하나를 줄 수 있음  
> 하지만 서로 최선의 선택을 한다는 조건이 있기 때문에 Win을 줄 수 없음  
> *결과적으로 값이 커져도패턴을 벗어날 수 없음*

[![코드 확인](https://img.shields.io/badge/코드_확인-blue?style=for-the-badge)](https://github.com/SamakFOX/SWEA-explanation/blob/main/java/D4_1210_ladder1.java)  
https://github.com/SamakFOX/SWEA-explanation/blob/main/java/D4_1210_ladder1.java  
* 초기에 시뮬레이션으로 구현하였으나, 일반적인 TC에선 가능하지만 10¹⁸에 가까운 소수의 경우 시간초과가 발생하여  
AI 분석을 통해 게임이론으로 로직을 변경하였습니다.

| 유형 | 예시 | A lose |
|---|---|---|
| 돌 빼기 게임 | 1~K 빼기 | K+1의 배수 |
| 약수 빼기 게임 | 현재 숫자에서 약수 C를 빼는 게임 | 홀수, 2의 지수가 홀수 |
| 배수 만들기 게임 | N이 k의 배수면 승 / 매번 +-값 선택 | N의 승패 상태가 고정 |
| 나무 자르기 게임 | 특정 길이로만 자를 수 있음 | 가능한 다음 상태 분석 |
| 동전 뒤집기 게임 | 뒤집을 수 있는 동전 수 제한 | 상태 → W/L 판정 |
| 카드 제거 게임 | 매 턴 일정 개수 제거 | 가능한 다음 상태 존재 여부 |
| 탑 쌓기 게임 | 특정 규칙으로 더하거나 빼기 | 상태 기반 최적 플레이 판정 |
| 념 게임 (Nim Game) | 여러 더미에서 돌 제거 | 그룬디 수(Grundy Number)로 W/L 판정 |
| Wythoff 게임 | 두 더미에서 1개씩 or 같은 개수 제거 | 수학적 패턴 그대로 존재 |

#### 돌 빼기 게임
2개씩 뺄수있다면 3의배수 턴에 있는 사람은 항상 지게됨 > 3-1=2 / 6-1=5,6-2=4
```java
// N % (K+1) == 0

K = 2;
if(N % 3 == 0)
```
#### 약수 빼기 게임


