import java.util.*;
import java.io.*;

public class Main{
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());// 1 ≤ N ≤ 20
		StringTokenizer st = new StringTokenizer(br.readLine());
		int question=Integer.parseInt(st.nextToken());
		long factorial[]=new long[N+1];
		factorial[1]=1;
		for(int i=2;i<=N;i++)
		{
			factorial[i]=factorial[i-1]*i;
		}
		
		int[]arr=new int[N];
		boolean[]visited=new boolean[N+1];
		
		if(question==1)
		{
			long k=Long.parseLong(st.nextToken()); // 1! ≤ N ≤ 20! 
			for(int i=0;i<N;i++)
			{ 
				for(int j=1;j<=N;j++)
				{					
					if(visited[j]==true)
					{
						continue;
					}
					if(i==N-1)
					{
						arr[i]=j;
						visited[j]=true;
						break;
					}
					if(k>factorial[N-(i+1)])
					{
						k-=factorial[N-(i+1)];
					}
					else
					{
						arr[i]=j;
						visited[j]=true;
						break;
					}
				}
				System.out.print(arr[i]+" ");
			}
		}
		else
		{
			long ans=1;
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());	
				int cnt=0;
				visited[arr[i]]=true;
				for(int j=1;j<=arr[i];j++)
				{
					if(visited[j]==false)
					{
						cnt++;
					}
				}
				for(int j=0;j<cnt;j++)
				{
					ans+=factorial[N-(i+1)];
				}
			}
			System.out.println(ans);
		}
	}
}