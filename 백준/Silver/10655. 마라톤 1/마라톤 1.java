import java.io.*;
import java.util.*;


public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_실버3_10655_마라톤1"));
		
		//입력값 입력 
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N=Integer.parseInt(br.readLine()); //마라톤 코스에 존재하는 체크포인트
		int[][]arr = new int[N][2];
		int sum=0;
		for(int i=0;i<N;i++)
		{
			st=new StringTokenizer(br.readLine());
			arr[i][0]=Integer.parseInt(st.nextToken());
			arr[i][1]=Integer.parseInt(st.nextToken());
		}
		//첫번째와 마지막 체크포인트는 무조건  방문
		for(int i=1;i<N;i++)
		{
			sum+=Math.abs(arr[i-1][0]-arr[i][0])+Math.abs(arr[i-1][1]-arr[i][1]);
		}
		//System.out.println(sum);
		int ans=Integer.MAX_VALUE;
		
		for(int i=1;i<N-1;i++)
		{
			int tmp=sum
					-(Math.abs(arr[i-1][0]-arr[i][0])+Math.abs(arr[i-1][1]-arr[i][1]))
					-(Math.abs(arr[i][0]-arr[i+1][0])+Math.abs(arr[i][1]-arr[i+1][1]))
					+(Math.abs(arr[i-1][0]-arr[i+1][0])+Math.abs(arr[i-1][1]-arr[i+1][1]));
			ans=Math.min(ans,tmp);
		}
		System.out.println(ans);
	}
}