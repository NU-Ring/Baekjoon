import java.io.*;
import java.util.*;


public class Main {

	public static int Y;
	public static int X;
	public static int K;
	public static int[][]arr;
	public static int ans;
	public static int dy[]= {-1,1,0,0};
	public static int dx[]= {0,0,-1,1};
	
	
	public static void dfs(boolean[][]visited , int cnt,int y,int x)
	{
		if(cnt>K)
		{
			return;
		}
		if(y==0&&x==X-1)
		{
			if(cnt==K)
			{
				ans++;
			}
			return;
		}
		
		for(int i=0;i<4;i++)
		{
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny>=0&&nx>=0&&ny<Y&&nx<X)
			{
				if(arr[ny][nx]==0&&visited[ny][nx]==false)
				{
					visited[ny][nx]=true;
					dfs(visited,cnt+1,ny,nx);
					visited[ny][nx]=false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_실버1_1189_컴백홈"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st =new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		K=Integer.parseInt(st.nextToken());
		arr=new int[Y][X];
		boolean visited[][]=new boolean[Y][X];
		for(int i=0;i<Y;i++)
		{
			char[] tmp=br.readLine().toCharArray();
			for(int j=0;j<X;j++)
			{
				if(tmp[j]=='.')
				{
					arr[i][j]=0;
				}
				else
				{
					arr[i][j]=1;
					visited[i][j]=true;
				}
			}
		}
		int cnt=1;
		ans =0;
		visited[Y-1][0]=true;
		dfs(visited,cnt,Y-1,0);
		System.out.println(ans);
	}

}
