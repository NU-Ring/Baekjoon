import java.io.*;
import java.util.*;

public class Main {

	public static int[][]arr;
	public static int N;
	public static int L;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_골드3_14890_경사로"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		//입력값 입력 시작
		N=Integer.parseInt(st.nextToken());
		L=Integer.parseInt(st.nextToken());
		arr=new int [N][N];
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			for(int j=0;j<N;j++)
			{
				arr[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		//입력값 입력 종료
		
		int ans=0;

		for(int i=0;i<N;i++)
		{
			if(check(true,i)) {ans++;}
			if(check(false,i)) {ans++;}
		}
		System.out.println(ans);

		// 경사로를 설치하는 경우(각 라인마다 별도)
		/*
		  1. 다음 계단이 현재보다 한칸 높을 경우
		  2. 다음 계단이 현재보다 한칸 낮을 경우
			
		    체크사항
		    경사로가 이미 설치뒤었는지 유무 확인
		  L길이만큼의 동일 높이
		
		 * */
	}
	public static boolean check(boolean flag,int p)
	{
		boolean bridge[]=new boolean[N];
		int[]now=new int[N];
		if(flag)
		{
			for(int i=0;i<N;i++)
			{
				now[i]=arr[i][p];
			}
		}
		else
		{
			for(int i=0;i<N;i++)
			{
				now[i]=arr[p][i];
			}
		}
		/////////////////////////////////해당 행/열을 now[]배열에 삽입(모두 가로배열로 치환)
		for(int i=0;i<N-1;i++)
		{
			int diff=now[i]-now[i+1];
			if(Math.abs(diff)>1) // 단차가 1보다 크면 불가능
			{
				return false;
			}
			else if(diff==0) //단차가 없으면 문제없음, 다음칸 체크로
			{
				continue;
			}
			else if(diff==-1) // 다음칸이 높음
			{
				if(i-(L-1)<0)
				{
					return false;
				}
				for(int k=0;k<L;k++)
				{
					if(now[i-k]!=now[i])
					{
						return false;
					}
					if(bridge[i-k]==true)
					{
						return false;
					}
					bridge[i-k]=true;
				}
			}
			else if(diff==1) // 다음칸이 낮음
			{
				if(i+L>=N)
				{
					return false;
				}
				for(int k=1;k<=L;k++)
				{
					if(now[i+k]!=now[i+1])
					{
						return false;
					}
					if(bridge[i+k]==true)
					{
						return false;
					}
					bridge[i+k]=true;
				}
			}	
		}
		return true;
	}
}