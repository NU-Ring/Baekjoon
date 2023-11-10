import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args)throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N=Integer.parseInt(br.readLine());//(50보다 작거나 같은 자연수)
		long[]arr = new long[N];//(1,000,000,000보다 작거나 같은 자연수)
		StringTokenizer st= new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++)
		{
			arr[i]=Integer.parseInt(st.nextToken());
		}
		int ans[]=new int[N];

		for (int i = 0; i < N-1; i++) {
	            ans[i]++;
	            ans[i+1]++; //현재건물과 현재건물 다음의 건물은 무조건 서로 볼 수 있음
	            double incline = arr[i+1] - arr[i];//현재 기울기 (다음 기울기는 이것보다 더 커야 함)
	            for (int j = i+2; j < N; j++)
	            {
	                double nextincline = (double)(arr[j]-arr[i])/(j-i);
	                if (nextincline > incline) {
	                	incline = nextincline;
	                    ans[i]++;//현재건물과 상대건물이 서로 바라볼 수 있기 때문
	                    ans[j]++;
	                }
	            }
	        }
		Arrays.sort(ans);
		System.out.println(ans[ans.length-1]);
	}
}