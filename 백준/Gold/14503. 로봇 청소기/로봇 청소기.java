import java.util.*;
import java.io.*;

public class Main {

	public static int[] dy= {-1,0,1,0};//북 동 남 서
	public static int[] dx= {0,1,0,-1};//상 우 하 좌
	public static int N;
	public static int M;
	
	public static int nextdir(int d)
	{
		d++;
		if(d==4) {
			d=0;
		}
		return d;
	}
	
	public static boolean chkarr(int y, int x)
	{
		if(y>=0&&x>=0&&y<N&&x<M)
		{
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*입력값 입력*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken()); //세로 길이
		M=Integer.parseInt(st.nextToken()); //가로 길이
		int arr[][]=new int[N][M];
		int ans=0;
		
		int[] robot=new int[3]; // y좌표, x좌표, 방향좌표
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<3;i++)
		{
			robot[i]=Integer.parseInt(st.nextToken());
		}
		
		//0 = 청소되지 않은 방      / 1=벽이 있는 방
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		
		while(true)
		{
			/*debug
			System.out.println("Y:"+robot[0]+" X:"+robot[1]+" dir:"+robot[2]);
			for(int i=0;i<N;i++)
			{
				for(int j=0;j<M;j++)
				{
					System.out.print(arr[i][j]+" ");
				}System.out.println();
			}System.out.println();
				*/
			// 현재 칸이 0일경우 청소
			if(arr[robot[0]][robot[1]]==0)
			{
				arr[robot[0]][robot[1]]=2;
				ans++;
			}
			
			int cnt=0;
			for(int i=0;i<4;i++)
			{
				int ny=robot[0]+dy[i];
				int nx=robot[1]+dx[i];
				
				if(chkarr(ny,nx))
				{
					if(arr[ny][nx]==0)
					{
						cnt++;
					}
				}
			}
			if(cnt==0)
			{
				int nd=(robot[2]+2)%4;
				int ny=robot[0]+dy[nd];
				int nx=robot[1]+dx[nd];
				
				//후진 할 수 있다면 후진 후 돌아가기
				if(chkarr(ny,nx))
				{
					if(arr[ny][nx]!=1)
					{
						robot[0]=ny;
						robot[1]=nx;
						continue;
					}
					else
					{
						break;
					}
				}
				else 
				{
					break;
				}
			}
			else
			{
				robot[2]=(robot[2]+4-1)%4;
				int ny=robot[0]+dy[robot[2]];
				int nx=robot[1]+dx[robot[2]];
				if(chkarr(ny,nx))
				{
					if(arr[ny][nx]==0)
					{
						robot[0]=ny;
						robot[1]=nx;
					}
				}
			}
			
		}
		System.out.println(ans);
	}
}