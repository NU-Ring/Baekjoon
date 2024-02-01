import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		//System.setIn(new FileInputStream("res/input_실버4_20125_쿠키의신체측정"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//(x,y) 로 표현 (1,1)~(N,N)칸 까지
		//출력: 심장의 위치\n 팔, 다리, 허리길이
		int N=Integer.parseInt(br.readLine());
		int[][]arr = new int[N+1][N+1];
		
		boolean flag=false;
		
		int[]ans=new int[7]; //심장x, 심장y, 왼팔, 오른팔, 허리, 왼다리, 오른다리 길이(위에서부터 리딩할 거기 떄문)
		
		//배열 입력 및 심장 위치 저장
		for(int i=0;i<N;i++)
		{
			char[] tmp=(br.readLine()).toCharArray();
			for(int j=0;j<N;j++)
			{
				if(tmp[j]=='*')
				{
					arr[i][j]=1;
				}
				if(tmp[j]=='*'&&flag==false)
				{
					//심장 위치(머리 y좌표 -1)
					ans[0]=i+2;    
					ans[1]=j+1;
					flag=true;
				}
			}
		}
		
		//왼팔, 오른팔, 허리 탐색
		int[] dx= {-1,1,0}; //인 오 아
		int[] dy= {0,0,1}; //왼 오 아
		for(int i=0;i<3;i++)
		{
			int ny=ans[0]-1;
			int nx=ans[1]-1;
			int len=0;
			while(arr[ny][nx]==1)
			{
				ny+=dy[i];
				nx+=dx[i];
				len++;
				if(ny>=N||nx>=N||ny<0||nx<0)
				{
					break;
				}
			}
			ans[i+2]=len-1;
		}
		
		//왼, 오 다리 탐색
		for(int i=0;i<2;i++)
		{
			int ny=ans[0]+ans[4];
			int nx=ans[1]-1;
			if(i==0)
			{
				nx-=1;
			}
			else
			{
				nx+=1;
			}
			int len=0;
			while(arr[ny+1][nx]==1)
			{
				ny++;
				len++;
			}
			ans[i+5]=len+1;
		}
		
		
		//정답 출력
		System.out.println(ans[0]+" "+ans[1]);
		for(int i=0;i<5;i++)
		{
			System.out.print(ans[i+2]+" ");
		}
	}
}