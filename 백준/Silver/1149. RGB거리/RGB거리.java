import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_실버1_1149_RGB거리"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());
		
		int cost[][] = new int[N][3];
		StringTokenizer st;
		int dp[][]=new int [N][3];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			cost[i][0]=Integer.parseInt(st.nextToken());
			cost[i][1]=Integer.parseInt(st.nextToken());
			cost[i][2]=Integer.parseInt(st.nextToken());
			
			dp[i][0]=Integer.MAX_VALUE;
			dp[i][1]=Integer.MAX_VALUE;
			dp[i][2]=Integer.MAX_VALUE;
		}
		
		dp[0][0]=cost[0][0];
		dp[0][1]=cost[0][1];
		dp[0][2]=cost[0][2];
		
		for(int i=1;i<N;i++)
		{
			for(int j=0;j<3;j++)
			{
				for(int k=0;k<3;k++)
				{
					if(k==j)
					{
						continue;
					}
					{
						dp[i][j]=Math.min(dp[i][j],cost[i][j]+dp[i-1][k]);
					}
					
				}
			}
		}
		
		int ans=Integer.MAX_VALUE;
		for(int i=0;i<3;i++)
		{
			ans=Math.min(ans,dp[N-1][i]);
		}
		System.out.println(ans);
		
		
	}

}
