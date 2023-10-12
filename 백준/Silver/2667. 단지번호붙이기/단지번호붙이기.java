import java.util.*;
import java.io.*;

public class Main {

	public static int N;
	public static int[][] arr;
	public static boolean[][] visited;
	public static int[] dy = {-1,1,0,0};//상 하 좌우
	public static int[] dx = {0,0,-1,1};//상 하 좌우
	
	public static void bfs(int y,int x, int cnt)
	{
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[]{y,x});
		visited[y][x]=true;
		arr[y][x]=cnt;
		
		while(!q.isEmpty())
		{
			int tmp[]=q.poll();
			for(int i=0;i<4;i++)
			{
				int ny=tmp[0]+dy[i];
				int nx=tmp[1]+dx[i];
				if(ny>=0&&nx>=0&&ny<N&&nx<N)
				{
					if(visited[ny][nx]==false&&arr[ny][nx]==1)
					{
						visited[ny][nx]=true;
						arr[ny][nx]=cnt;
						q.add(new int[]{ny,nx});
					}
				}
			}
		}
	}
	
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
		N=Integer.parseInt(br.readLine());
		arr = new int[N][N];
		char[]tmp = new char[N];
		visited=new boolean[N][N];
		
		for(int i=0;i<N;i++)
		{
			 tmp=br.readLine().toCharArray();
			 for(int j=0;j<N;j++)
			 {
				 arr[i][j]=tmp[j]-'0';
			 }
		}
		
		
		int cnt=1;
		for(int i=0;i<N;i++)
		{
			 for(int j=0;j<N;j++)
			 {
					if(visited[i][j]==false&&arr[i][j]==1)
					{
						bfs(i,j,cnt);
						cnt++;
					}
			 }
		}
		int ans[]=new int[cnt-1];
		for(int i=0;i<N;i++)
		{
			for(int j=0;j<N;j++)
			{
				if(arr[i][j]>0)ans[arr[i][j]-1]++;
			}
		}
		
		System.out.println(cnt-1);
		Arrays.sort(ans);
		for(int i=0;i<cnt-1;i++)
		{
			System.out.println(ans[i]);
		}
	}
}
