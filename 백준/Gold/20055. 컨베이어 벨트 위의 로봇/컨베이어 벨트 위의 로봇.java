import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int K=Integer.parseInt(st.nextToken());

		boolean[]robot=new boolean[N]; // 로봇은 무조건 N에서 하차하기때문
		int[]belt=new int[2*N]; // 0부터 2N-1까지
		
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<2*N;i++)
		{
			belt[i]=Integer.parseInt(st.nextToken());
		}

		int cnt=0;
		int tmp=0;
		while(true)
		{
			cnt++;
			//1. 벨트가 각 칸위에 있는 로봇과 함께 한 칸 회전한다.
			tmp=belt[2*N-1];
			for(int i=2*N-1;i>0;i--)
			{
				belt[i]=belt[i-1];
			}
			belt[0]=tmp;
			
			for(int i=N-1;i>0;i--)
			{
				robot[i]=robot[i-1];
			}
			robot[0]=false; // 이동했기 때문에 시작점에는 무조건 로봇이 없다
			robot[N-1]=false; // 로봇의 하차(있어도 없어도 무조건 없는 상태여야 한다)
		
		
			//2. 가장 먼저 벨트에 올라간 로봇부터, 벨트가 회전하는 방향으로 한 칸 이동할 수 있다면 이동한다. 만약 이동할 수 없다면 가만히 있는다.
			for(int i=N-2;i>=0;i--)
			{
				if(robot[i]==true&&robot[i+1]==false&&belt[i+1]>=1) // 다음칸에 로봇이 없고 다음칸이 내구성이 있는 칸이라면
				{
					belt[i+1]--;
					if(belt[i+1]==0)
					{
						K--;
					}
					robot[i]=false;
					robot[i+1]=true;
				}
			}
			
			//3.올리는 위치에 있는 칸의 내구도가 0이 아니면 올리는 위치에 로봇을 올린다.
			if(belt[0]>=1)
			{
				robot[0]=true;
				belt[0]--;
				if(belt[0]==0)
				{
					K--;
				}
			}
			
			//4.내구도가 0인 칸의 개수가 K개 이상이라면 과정을 종료한다. 그렇지 않다면 1번으로 돌아간다.
			if(K<=0) //위 과정에서 내구도가 여러번 감소하기때문에 0보다 작아질수도있다
			{
				break;
			}
		}	
		System.out.println(cnt);
	}
}