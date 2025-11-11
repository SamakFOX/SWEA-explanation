import java.util.Scanner;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/* 주어진 A에 자연수B를 곱한 결과가 거듭제곱이 되는 최소의 B */

// 메모리: 49,016kb / 실행시간: 585ms / 코드길이: 1,295 
 
class Solution {
    public static void main(String args[]) throws Exception {
        System.setIn(new FileInputStream("res/input_for_10965.txt"));
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int T;
        T = Integer.parseInt(br.readLine());
         
         
        for(int test_case = 1; test_case <= T; test_case++) {
            int input = Integer.parseInt(br.readLine());
            int result = getResult(input);
            bw.write("#" + test_case + " " + result + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
     
    static int getResult(int input) {
        int result = 1;
        for (int i = 2; i * i <= input; i++) {
            int count = 0;
            while (input % i == 0) {
                input /= i;
                count++;
            }
            if (count % 2 != 0) result *= i;
        }
        if (input > 1) result *= input;
        return result;
    }
}
