import java.util.*;
import java.io.*;

public class Main {

	//전역변수 선언
	public static int N; //1 ≤ N ≤ 50
	public static int L; //1 ≤ L ≤ R ≤ 100
	public static int R; //1 ≤ L ≤ R ≤ 100
	public static int arr[][];
	public static int ans;
	public static int dy[]= {-1,1,0,0};//상하좌우 이동 시 y이동
	public static int dx[]= {0,0,-1,1};//상하좌우 이동 시 x이동

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		//입력값 입력
		N=Integer.parseInt(st.nextToken()); // N*N
		L=Integer.parseInt(st.nextToken()); //L명 이상
		R=Integer.parseInt(st.nextToken()); //R명 이하 이면 인구이동
		arr=new int[N][N];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		ans=-1;
		boolean flag=true;//국가 분열이 하나라도 일어나면 true로 변경하는 형식으로 돌게 하기 위해
		while(flag)
		{
			flag=false;
			ans++;
			boolean visited[][]=new boolean [N][N];
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					if(visited[i][j]==true)
					{
						continue;
					}
					else
					{
						Queue<int[]>q=new LinkedList<>();
						Queue<int[]>save=new LinkedList<>();
						q.offer(new int[] {i,j});
						save.offer(new int[] {i,j});
						visited[i][j]=true;
						int cnt=1;
						int sum=arr[i][j];
						while(!q.isEmpty())
						{
							int[] tmp=q.poll();
							for(int d=0;d<4;d++)
							{
								int ny=tmp[0]+dy[d];
								int nx=tmp[1]+dx[d];
								if(ny>=0&&ny<N&&nx>=0&&nx<N)
								{
									//System.out.println(i+" "+j+" "+ny+" "+nx+" "+Math.abs(arr[i][j]-arr[ny][nx]));
									if((Math.abs(arr[tmp[0]][tmp[1]]-arr[ny][nx])>=L)&&(Math.abs(arr[tmp[0]][tmp[1]]-arr[ny][nx])<=R)&&visited[ny][nx]==false)
									{
										cnt++;
										sum+=arr[ny][nx];
										save.offer(new int[] {ny,nx});
										//System.out.println("save:"+ny+" "+nx);
										q.offer(new int[] {ny,nx});
										visited[ny][nx]=true;
										flag=true;
									}
								}
							}
						}
						while(!save.isEmpty())
						{
							int[]tmp=save.poll();
							arr[tmp[0]][tmp[1]]=sum/cnt;
						}
					}
				}
			}
		/*	for(int i=0;i<N;i++)
			{
				for(int j=0;j<N;j++)
				{
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}System.out.println("T");
		 */
		}
		//정답 출력
		System.out.println(ans);
	}
}