import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int M;
	public static int H;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_골드4_18427_함께블록쌓기"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); // 1 ≤ N ≤ 50       학생 수
		M=Integer.parseInt(st.nextToken()); // 1 ≤ M ≤ 10       한 학생이 쌓을 수 있는 최대 블록 수
		H=Integer.parseInt(st.nextToken()); // 1 ≤ H ≤ 1,000 높이가 H인 탑을 만들 수 있는 경우의 수
		
		ArrayList<Integer>[] list = new ArrayList[N+1];
		for(int i=1;i<=N;i++)
		{
			list[i]=new ArrayList<>();
		}
		for(int i=1;i<=N;i++)
		{
			st=new StringTokenizer(br.readLine());
			while(st.hasMoreTokens())
			{
				list[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		//입력값 종료
		
		int [][] dp = new int[N+1][H+1]; // N명의 학생으로 H높이의 탑 만드는 경우의 수
		for(int i=0;i<=N;i++)//높이가 0이 되는 경우는 모두 1이기에 1로 초기화
		{
			dp[i][0]=1;
		}
		/*경우의 수 를 빈칸에 채워넣기
		 *         총합높이0	총합높이1	총합높이2	총합높이3	총합높이4	총합높이5
		 *학생번호1|    1       x       1       1       x       1
		 *학생번호2|    1                                 
		 *학생번호3|    1
		 * 
		 * */
		// K번쨰 학생이 자신의 블록을 선택하지 않을 때: dp[K][H]=dp[K-1][H]
		for(int i=1;i<=N;i++) // 학생번호
		{
			for(int j=1;j<=H;j++) // 총합높이
			{
				for(int k:list[i])
				{
					if(j>=k) // 높이가 현재 가지고 있는 블록보다 높을 경우 
					{
//						System.out.println(i+" "+j+" "+k+" "+dp[i][j] );
						dp[i][j]=(dp[i-1][j-k]+dp[i][j])%10007; // 블록을 쌓음
					}
				}
				dp[i][j]=(dp[i-1][j]+dp[i][j])%10007; //이전에 만들어진 경우의 수 그대로 가져오기
			}
		}
		System.out.println(dp[N][H]%10007);
	}
}