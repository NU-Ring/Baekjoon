import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		//BufferedReader br = new BufferedReader(new FileReader("src/input"));
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		//입력값 시작
		StringTokenizer st=new StringTokenizer(br.readLine());
		int X=Integer.parseInt(st.nextToken());//가로 길이
		int Y=Integer.parseInt(st.nextToken());//세로 길이
		int S=Integer.parseInt(br.readLine()); //상점의 개수
		int []arr = new int[S+1];
		for(int i=0;i<=S;i++)
		{
			st=new StringTokenizer(br.readLine());
			int way=Integer.parseInt(st.nextToken());
			int pos=Integer.parseInt(st.nextToken());
			if(way==1)//위
			{
				arr[i]=pos;
	
			}
			else if(way==2)//아래
			{
				arr[i]=X+Y+X-pos;

			}
			else if(way==3)//왼
			{
				arr[i]=X+Y+X+Y-pos;

			}
			else //오
			{
				arr[i]=X+pos;

			}//System.out.println(arr[i]);
		}
		//입력값 종료
		int ans=0;
		
		//구현 시작
		for(int i=0;i<S;i++)
		{
			if(arr[S]>arr[i])
			{
				ans+= Math.min(
						arr[S]-arr[i],Y+Y+X+X-(arr[S]-arr[i])
						);
			}
			else
			{
				ans+= Math.min(
						arr[i]-arr[S],Y+Y+X+X-(arr[i]-arr[S])
						);				
			}
			
		}
		sb.append(ans);
		System.out.println(sb.toString());
	}

}
