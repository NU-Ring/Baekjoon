import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(br.readLine());
		long arr[] = new long[n];// -1,000,000,000 이상 1,000,000,000 이하
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<n;i++)
		{
			arr[i]=Long.parseLong(st.nextToken());// 오름차순으로 입력
		}
		
		int pt1=0;
		int pt2=n-1;
		long ans1=0, ans2=0;
		long min=Long.MAX_VALUE;
		while(pt1<pt2)
		{
			long sum=arr[pt1]+arr[pt2];
			
			if(min>Math.abs(sum))
			{
				min=Math.abs(sum);
				ans1=arr[pt1];
				ans2=arr[pt2];
			}
			
			if(sum==0)
			{
				break;
			}
			else if(sum>0)
			{
				pt2--;
			}
			else //sum<0
			{
				pt1++;
			}
		}
		System.out.println(ans1+" "+ans2);
	}
}