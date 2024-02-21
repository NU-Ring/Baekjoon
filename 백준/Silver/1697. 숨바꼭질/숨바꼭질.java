import java.util.*;
import java.io.*;

public class Main{

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n=Integer.parseInt(st.nextToken());
		int k=Integer.parseInt(st.nextToken());
		int dp[]=new int[Math.max(n,k)*2+1];
		int ans=0;
		if(n==k)
		{
			System.out.println(0);
			return;
		}
		Queue<int[]>q=new LinkedList<>();
		q.offer(new int[] {n,1});
		dp[n]=1;
		while(!q.isEmpty())
		{
			int tmp[]=q.poll();
			//걷기
			if(tmp[0]+1<=Math.max(n,k)*2)
			{
				if(tmp[0]+1==k)
				{
					ans=tmp[1]+1;
					q.clear();
                    break;
				}
				else if(dp[tmp[0]+1]==0)
				{
					dp[tmp[0]+1]=tmp[1]+1;
					q.offer(new int[] {tmp[0]+1,tmp[1]+1});
				}
			}
			
			if(tmp[0]-1>=0)
			{
				if(tmp[0]-1==k)
				{
					ans=tmp[1]+1;
					q.clear();
                     break;
				}
				else if(dp[tmp[0]-1]==0)
				{
					dp[tmp[0]-1]=tmp[1]+1;
					q.offer(new int[] {tmp[0]-1,tmp[1]+1});
				}
			}
			//순간이동
			if(tmp[0]*2<=Math.max(n,k)*2)
			{
				if(tmp[0]*2==k)
				{
					ans=tmp[1]+1;
					q.clear();
				}
				else if(dp[tmp[0]*2]==0)
				{
					dp[tmp[0]*2]=tmp[1]+1;
					q.offer(new int[] {tmp[0]*2,tmp[1]+1});
				}
			}
		}
		System.out.println(ans-1);
	}
}