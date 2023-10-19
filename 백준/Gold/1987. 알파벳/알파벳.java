import java.io.*;
import java.util.*;

public class Main {
	
	public static int dy[] = {-1,1,0,0};
	public static int dx[] = {0,0,-1,1};
	public static int answer;
	public static char[][] arr;
	
	public static int Y;
	public static int X;
	
	public static void dfs(int y, int x, int cnt, boolean chk[], boolean visited[][])
	{
		answer=Math.max(answer,cnt);

		for(int i=0;i<4;i++)
		{
			int ny=y+dy[i];
			int nx=x+dx[i];
			if(ny>=0&&nx>=0&&ny<Y&&nx<X)
			{
				if(visited[ny][nx]==false && chk[arr[ny][nx]-'A']==false)
				{
					visited[ny][nx]=true;
					chk[arr[ny][nx]-'A']=true;
					dfs(ny,nx,cnt+1,chk,visited);
					visited[ny][nx]=false;
					chk[arr[ny][nx]-'A']=false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input_골드4_1987_알파벳"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		arr = new char[Y][X];
		
		for(int i=0;i<Y;i++)
		{
			arr[i]=br.readLine().toCharArray();
		}
		
		boolean[] chk = new boolean[26];
		boolean[][] visited = new boolean[Y][X];
		answer=0;

		chk[arr[0][0]-'A']=true;
		visited[0][0]=true;
		dfs(0,0,1,chk,visited);

		System.out.println(answer);
	}

}
