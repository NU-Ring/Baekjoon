import java.util.*;
import java.io.*;

public class Main {

	public static int Y;
	public static int X;
	public static int arr[][];
	
	public static int[] dy= {-1,1,0,0};
	public static int[] dx= {0,0,-1,1};
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//BufferedReader br = new BufferedReader(new FileReader("src/input_골드4_4179_불"));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Y=Integer.parseInt(st.nextToken());
		X=Integer.parseInt(st.nextToken());
		arr=new int[Y+2][X+2];
		/*
		    #: 벽
			.: 지나갈 수 있는 공간
			J: 지훈이의 미로에서의 초기위치 (지나갈 수 있는 공간)
			F: 불이 난 공간
		*/
		Queue<int[]>jihun=new LinkedList<>();
		boolean visited[][]=new boolean[Y+1][X+1];
		Queue<int[]>fire=new LinkedList<>();
		for(int i=1;i<=Y;i++)
		{
			char[]tmp=br.readLine().toCharArray();
			for(int j=1;j<=X;j++)
			{
				if(tmp[j-1]=='#')//벽= -1
				{arr[i][j]=-1;}
				else if(tmp[j-1]=='.')//지나갈 수 있는 공간 = -2
				{arr[i][j]=-2;}
				else if(tmp[j-1]=='J')//지훈이의 초기 위치저장을 위한
				{arr[i][j]=-2;	jihun.offer(new int[] {i,j,0}); visited[i][j]=true;}
				else if(tmp[j-1]=='F')//불인 공간(큐에 삽입)=0
				{
					arr[i][j]=0;
					fire.offer(new int[]{i,j,0});
				}
			}
		}
		while(!fire.isEmpty())
		{
			int[]now=fire.poll();
			for(int i=0;i<4;i++)
			{
				int ny=now[0]+dy[i];
				int nx=now[1]+dx[i];
				int nt=now[2]+1;
				if(ny>0&&nx>0&&ny<=Y&&nx<=X)
				{
					if((arr[ny][nx])==-2)
					{
						arr[ny][nx]=nt;
						fire.offer(new int[] {ny,nx,nt});
					}
				}
			}
		}

		int ans=Integer.MAX_VALUE;
		while(!jihun.isEmpty())
		{
			int now[]=jihun.poll();
			for(int i=0;i<4;i++)
			{
				int ny=now[0]+dy[i];
				int nx=now[1]+dx[i];
				int nt=now[2]+1;
				if(ny<1||ny>Y||nx<1||nx>X)
				{
					jihun.clear();
					ans=nt;
					break;
				}
				else if(arr[ny][nx]>nt&&arr[ny][nx]>=0&&visited[ny][nx]==false)
				{
					jihun.offer(new int[] {ny,nx,nt});
					visited[ny][nx]=true;
				}
				else if(visited[ny][nx]==false&&arr[ny][nx]==-2)
				{
					jihun.offer(new int[] {ny,nx,nt});
					visited[ny][nx]=true;
				}
			
			}
			
		}
		
		
		
		if(ans!=Integer.MAX_VALUE)
		{
			System.out.println(ans);
		}
		else
		{
			System.out.println("IMPOSSIBLE");
		}	
	}
}