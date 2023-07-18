package day07.greedy;

import java.io.*;
import java.util.*;

public class D_S5209_최소생산비용_sol {
    static int N, B, ans;
    static int[][] arr;
    static boolean[] v;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));  //  파일로부터 읽기
        StringTokenizer st = new StringTokenizer(br.readLine());
 
        //  [0] 입력처리
        int TC = Integer.parseInt(st.nextToken());
        for (int tc=1; tc<=TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N][N];
            v = new boolean[N];
            for (int i=0;i<N;i++) {
                st = new StringTokenizer(br.readLine());
                for (int j=0; j<N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }
//          System.out.println(Arrays.deepToString(arr));
             
            //  가장위의 함수를 호출!
            ans = 99*N;
            dfs(0, 0);
            System.out.println("#"+tc+" "+ans);     
        }
    }
     
    public static void dfs(int n, int sum) {
        //  [2] 가지치기: 가장 위에서, 가장 마지막에!!!!
        if (ans<=sum)    return;     //  이미 현재까지의 최소값과 동일하거나 크면, 절대! 정답갱신 되지 않음 => 싹둑!
 
        //  [0] n에 관련된 종료조건: 정답처리
        if (n==N) {
            ans = Math.min(ans, sum);
            return;
        }
         
        //  [1] 하부호출
        for (int j=0; j<N; j++) {
            if (v[j]) continue;     // 이미 사용한 공장이면.. skip 후 다음으로..
            v[j] = true;
            dfs(n+1, sum+arr[n][j]);
            v[j] = false;
        }
    }
 
}