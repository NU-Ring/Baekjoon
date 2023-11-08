import java.util.*;
import java.io.*;

public class Main {
	public static int N;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N=Integer.parseInt(br.readLine()); //  조건: 200이하
		int M=Integer.parseInt(br.readLine()); // 조건: 1000이하
		int way[][]=new int[N+1][N+1];
		StringTokenizer st;
		for(int i=1;i<=N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++)
			{
				way[i][j]=Integer.parseInt(st.nextToken());
				if(i==j)
				{
					way[i][j]=1;
				}
			}
		}// i - j 연결 여부를 입력받음, 1이면 연결되있는 길
		int[]plan=new int[M];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<M;i++)
		{
			plan[i]=Integer.parseInt(st.nextToken());
		}//여행 계획을 입력받음
		//입력값 입력 종료
		
		//연결 여부 확인 (i->k->j 로 갈 수 있으면 i->j는 연결되있는 것)
		for(int k=1;k<=N;k++)
		{
			for(int i=1;i<=N;i++)
			{
				for(int j=1;j<=N;j++)
				{
					if(way[i][k]==1&&way[k][j]==1)
					{
						way[i][j]=1;
					}
				}
			}
		}
		
		//탐색 시작
		for(int i=0;i<M-1;i++)
		{
			int from=plan[i];
			int to=plan[i+1];
			if(way[from][to]==0)
			{
				System.out.println("NO");
				return;
			}
		}
		System.out.println("YES");
	}
}
