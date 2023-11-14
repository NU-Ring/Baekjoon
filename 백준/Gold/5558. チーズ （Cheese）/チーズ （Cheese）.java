import java.util.*;
import java.io.*;
public class Main {
	
	public static int H;
	public static int W;
	public static int N;
	public static int[] dy= {-1,1,0,0};//상하좌우
	public static int[] dx= {0,0,-1,1};//상하좌우
	public static int[][]arr;
	public static int[] mouse;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		H=Integer.parseInt(st.nextToken());// (1 ≦ H ≦ 1000) 세로
		W=Integer.parseInt(st.nextToken());// (1 ≦ W ≦ 1000) 가로
		N=Integer.parseInt(st.nextToken());// (1 ≦ N ≦ 9) 치즈의 개수(각 치즈는 모두 강도가 다름)
		int ans=0; //치즈를 모두 먹기까지 걸리는 최단 시간
		//시작점 s   장애물 x    빈땅 .    숫자 강도의 치즈
		arr = new int[H][W];
		mouse=new int[3];
		for(int i=0;i<H;i++)
		{
			char[]tmp=br.readLine().toCharArray();
			for(int j=0;j<W;j++)
			{
				if(tmp[j]=='S')
				{
					mouse[0]=i;
					mouse[1]=j;
					arr[i][j]=0;
				}
				else if(tmp[j]=='X')
				{
					arr[i][j]=-1;
				}
				else if(tmp[j]=='.')
				{
					arr[i][j]=0;
				}
				else
				{
					arr[i][j]=tmp[j]-'0';
				}
			}
		}
		/* 지도 출력 확인 디버그
		for(int i=0;i<H;i++)
		{
			for(int j=0;j<W;j++)
			{
				System.out.print(arr[i][j] +" ");
			}System.out.println();
		}*/
		
		Queue<int[]>q=new LinkedList<>();
		for(int i=1;i<=N;i++)
		{
			boolean visited[][]=new boolean[H][W];
			q.offer(new int[] {mouse[0],mouse[1],mouse[2]});
			visited[mouse[0]][mouse[1]]=true;
			while(!q.isEmpty())
			{
				int[]tmp=q.poll();
				for(int d=0;d<4;d++)
				{
					int ny=tmp[0]+dy[d];
					int nx=tmp[1]+dx[d];
					int nt=tmp[2]+1;
					if(ny>=0&&nx>=0&&ny<H&&nx<W)
					{
						if(visited[ny][nx]==false)
						{
							if(arr[ny][nx]==i)
							{
								//System.out.println("치즈"+i+"를 먹음"+nt+"초 경과");
								q.clear();
								mouse[0]=ny;
								mouse[1]=nx;
								mouse[2]=nt;
								arr[ny][nx]=0;
								ans=nt;
							}
							else if(arr[ny][nx]>=0)
							{
								visited[ny][nx]=true;
								q.offer(new int[] {ny,nx,nt});
							}
						}
					}
				}
			}
		}
		System.out.println(ans);
	}
}