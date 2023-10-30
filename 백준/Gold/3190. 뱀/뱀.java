import java.util.*;
import java.io.*;

public class Main {

	public static int N; // 맵 크기 NxN
	public static int K; // 사과 개수 
	public static int L; // 뱀의 방향 변환 횟수
	public static int[][] arr;
	public static String[][] act;
	public static ArrayList<int[]>snake;
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_골드4_3190_뱀"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		//입력값 시작
		N=Integer.parseInt(br.readLine());
		K=Integer.parseInt(br.readLine());
		
		arr=new int[N+1][N+1];
		StringTokenizer st;
		for(int i=0;i<K;i++)
		{
			st=new StringTokenizer(br.readLine());
			arr[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]=1;
		}
		
	
	
		L=Integer.parseInt(br.readLine());
		act = new String[L+1][2];
		for(int i=0;i<L;i++)
		{
			st=new StringTokenizer(br.readLine());
			act[i][0]=st.nextToken();
			act[i][1]=st.nextToken();
		}

		snake = new ArrayList<>();
		int dy[]= {-1,0,1,0};
		int dx[]= {0,-1,0,1}; //상좌하우
		snake.add(new int[] {1,1});
		int ny=1; 
		int nx=1;
		int pos=3; //상좌하우
		int ans=0;
		int turn =0;
		
		while(true)
		{
			ans++;
			// 뱀 머리 이동
			ny+=dy[pos];
			nx+=dx[pos];
			// 부딪히는지, 자신과 만나는지 확인
			if(!check(ny,nx))
			{
				break;
			}
			// 사과 여부 체크
			if(arr[ny][nx]==1)
			{
				arr[ny][nx]=0; 
				snake.add(new int[] {ny,nx});
			}
			else
			{
				snake.add(new int[] {ny,nx});
				snake.remove(0);
			}
			
			if(turn<L&&Integer.parseInt(act[turn][0])==ans)
			{
				
				if(act[turn][1].equals("L"))//왼
				{
					if(pos==3)
					{
						pos=0;
					}
					else
					{
						pos++;
					}
				}
				else if(act[turn][1].equals("D"))//오
				{
					if(pos==0)
					{
						pos=3;
					}
					else
					{
						pos--;
					}
				}
				turn ++;
			}
			
		}
		System.out.println(ans);
		
	}
	public static boolean check(int y, int x) {
		if(y<1||x<1||y>N||x>N)
		{
			return false;
		}
		for(int i=0;i<snake.size();i++)
		{
			int tmp[]=snake.get(i);
			if(y==tmp[0]&&x==tmp[1])
			{
				return false;
			}
		}
		return true;
	}
}
