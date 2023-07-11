package day02.array;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class S_2001_sol_합배열 {
 
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());
        for (int tc=0; tc<T; tc++) {
            int ans = 0;
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); //배열크기
            int M = Integer.parseInt(st.nextToken()); //파리채크기
             
            //배열 입력 및 구간합 배열 만들기
            int[][] sum = new int[N+1][N+1]; //한칸씩 여유두기
            for (int i=1; i<N+1; i++) {
                st = new StringTokenizer(br.readLine(), " ");
                for (int j=1; j<N+1; j++) {
                    sum[i][j] = sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+Integer.parseInt(st.nextToken());
                }
            }
//          System.out.println(Arrays.deepToString(sum));
             
            //배열 순환 하면서 가장 큰 합 구하기
            for (int i=M; i<N+1; i++) {
                for (int j=M; j<N+1; j++) {
                    int si = i-M+1, sj = j-M+1;
                    int tmp = sum[i][j] - sum[si-1][j] - sum[i][sj-1] + sum[si-1][sj-1];
                    ans = Math.max(ans, tmp);
                }
            }
             
            sb.append("#"+(tc+1)+" "+ans).append("\n");
        }
        System.out.println(sb);
    }
}