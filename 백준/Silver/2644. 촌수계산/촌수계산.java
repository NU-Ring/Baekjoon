import java.util.*;
import java.io.*;

public class Main {
	
	public static int N;
	public static int target1;
	public static int target2;
	public static int M;
	public static int[][] arr;
	public static int ans;
	public static boolean[]visited;
	public static void dfs(int now,int level)
	{
		visited[now]=true;
		if(now==target1)
		{
			ans=level;
			return;
		}
		for(int i=1;i<N;i++)
		{
			if(arr[i][now]==1&&visited[i]!=true)
			{
				dfs(i,level+1);
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
		
		N=Integer.parseInt(br.readLine());
		StringTokenizer st= new StringTokenizer(br.readLine());
		target1=Integer.parseInt(st.nextToken());
		target2=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(br.readLine());
		arr=new int[N+1][N+1];
		ans=0;
		for(int i=0;i<M;i++)
		{
			st=new StringTokenizer(br.readLine());
			int tmp1=Integer.parseInt(st.nextToken());
			int tmp2=Integer.parseInt(st.nextToken());
			arr[tmp1][tmp2]=1;
			arr[tmp2][tmp1]=1;
		}
		
		visited=new boolean[N+1];
		dfs(target2,0);
			if(ans==0)
		{
			System.out.println(-1);
		}
		else
		{
			System.out.println(ans);
		}
	}
}