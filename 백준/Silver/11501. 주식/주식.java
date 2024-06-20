import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T=Integer.parseInt(br.readLine());
		for(int tc=0;tc<T;tc++)
		{
			long ans=0;
			int N=Integer.parseInt(br.readLine());//날의 수를 나타내는 자연수
			int arr[]=new int[N];
			st= new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++)
			{
				arr[i]=Integer.parseInt(st.nextToken());
			}
			//입력값 입력 종료	
			long max=arr[N-1];
			for(int i=N-2;i>=0;i--)
			{
				if(arr[i]<max)
				{
					ans+=max-arr[i];
				}
				else
				{
					max=arr[i];
				}
			}
			System.out.println(ans);
		}
	}
}
