import java.util.*;
import java.io.*;

public class Main {

    public static int n;
	public static int[][]arr;
	public static int[]baby;
    public static int[]dy= {-1,1,0,0}; //상하좌우 이동
    public static int[]dx= {0,0,-1,1}; //상하좌우 이동
    public static int[][]dist;

	static class Point{
		int y;
		int x;
		int dis;
		
		Point(int y, int x, int dis)
		{
			this.y=y;
			this.x=x;
			this.dis=dis;
		}
	}
    
	public static void main(String[] args) throws Exception {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n=Integer.parseInt(br.readLine()); // 배열 크기 입력
		arr=new int [n][n]; // 배열 선언
		baby=new int[4]; // 아기상어의 정보 저장용 배열, Y위치, X위치, 크기, 해당 크기에서 먹은 물고기 마리수
		StringTokenizer st;

		for(int i=0;i<n;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<n;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
				if(arr[i][j]==9)
				{
					arr[i][j]=0;
					baby[0]=i;//최초 상어 Y위치
					baby[1]=j;//최초 상어 X위치
					baby[2]=2;//최초 상어 크기
				}
			}
		}

		Point movept = new Point(baby[0], baby[1], 0); 
		//아기 상어가 이동할 장소
		//최초 시작 시 현재 거리를 넣고 거리를 0으로 지정
		
		int ans=0;
		
		while(true) {
			boolean visited[][]=new boolean[n][n];
			Queue<Point> q = new LinkedList<>();
			visited[movept.y][movept.x]=true;
			q.offer(new Point(movept.y, movept.x,0));	
			movept.dis=Integer.MAX_VALUE;//초기화(최소값을 찾아야 하기 때문에)
			
			while(!q.isEmpty())
			{
				Point tmp=q.poll();
				if(tmp.dis>movept.dis)
				{
					break;
				}// 나온 거리 값이 현재 저장된 최소 거리값보다 클 경우 중지(거리가 가까운 곳을 우선으로 탐색하기 떄문에)
				
				if(arr[tmp.y][tmp.x]!=0&&arr[tmp.y][tmp.x]<baby[2]) // 먹을 수 있는 물고기
				{
					if(tmp.dis<movept.dis)
					{
						movept=tmp;
					}
					else if(tmp.dis==movept.dis) // 거리가 같다면
					{
						if(tmp.y<movept.y) //y값이 작은 값을 우선으로 두고
						{
							movept=tmp;
						}
						else if(tmp.y==movept.y&&tmp.x<movept.x) // y값이 같다면 x값이 작은 것을 우선으로 둠
						{
							movept=tmp;
						}
					}
					continue;
				}
				
				for(int i=0;i<4;i++)
				{
					int ny=tmp.y+dy[i];
					int nx=tmp.x+dx[i];
					if(ny>=0&&nx>=0&&ny<n&&nx<n)
					{
						if(visited[ny][nx]==false&&arr[ny][nx]<=baby[2])
						{
							visited[ny][nx]=true;
							q.offer(new Point(ny,nx,tmp.dis+1));
						}
					}
					
				}
			}
			if(movept.dis!=Integer.MAX_VALUE)
			{
				ans+=movept.dis;
				baby[3]++;
				if(baby[3]==baby[2])
				{
					baby[2]++;
					baby[3]=0;
				}
				arr[movept.y][movept.x]=0;
			}
			else
			{
				break;
			}
		}
		System.out.println(ans);
	}
}