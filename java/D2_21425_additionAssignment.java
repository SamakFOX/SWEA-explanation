import java.util.Scanner;
import java.io.FileInputStream;

/* A += B 또는 B += A 연산으로 N을 초과시킬 때의 최소연산 수 */

// 메모리: 31,728kb / 실행시간: 134ms / 코드길이: 591

class Solution
{
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T;
        T=sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int inA = sc.nextInt();
            int inB = sc.nextInt();
            int inN = sc.nextInt();
            int result = checkABN(inA, inB, inN);
            System.out.println(result);
        }
    }
     
    private static int checkABN(int a, int b, int n) {
        int count = 0;
        while(a <= n && b <= n) {
            if (a >= b) b += a;
            else a += b;
            count++;
        }
        return count;
    }
}
