import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		/*1. 입력값 입력 시작. 블로그를 시작하고 지난 일수 N과 X일동안 가장 많이 들어온 방문자 수와 기간 구하기*/
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int X=Integer.parseInt(st.nextToken());
		int arr[]=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		
		int spointer=0;
		int epointer=X;
		int max_ans=0;
		int cnt=0;
		int sumarr[]=new int[N];
		sumarr[0]=arr[0];
		//구간합
		for(int i=1;i<N;i++)
		{
			sumarr[i]=sumarr[i-1]+arr[i];
		}
		
		for(int i=0;i+X-1<N;i++)
		{
			if(max_ans<sumarr[i+X-1]-sumarr[i]+arr[i])
			{
				max_ans=sumarr[i+X-1]-sumarr[i]+arr[i];
				cnt=1;
			}
			else if(max_ans==sumarr[i+X-1]-sumarr[i]+arr[i])
			{
				cnt++;
			}
		}
		if(max_ans==0)
		{
			System.out.println("SAD");
		}
		else
		{
			System.out.println(max_ans);
			System.out.println(cnt);
		}
		
	}
}
