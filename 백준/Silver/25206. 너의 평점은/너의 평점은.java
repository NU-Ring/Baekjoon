import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("res/input_실버5_25206_너의평점은"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		double credit=0;
		double ans=0;
		for(int i=0;i<20;i++)
		{
			st=new StringTokenizer(br.readLine());
			String tmp=st.nextToken(); //과목명
			double score=Double.parseDouble(st.nextToken()); // 학점
			String grade=st.nextToken(); // 등급
			double gradescore=0;
			if(!grade.equals("P"))
			{
				if(grade.equals("A+"))
				{
					gradescore=4.5;
				}
				else if(grade.equals("A0"))
				{
					gradescore=4.0;
				}
				else if(grade.equals("B+"))
				{
					gradescore=3.5;
				}
				else if(grade.equals("B0"))
				{
					gradescore=3.0;
				}else if(grade.equals("C+"))
				{
					gradescore=2.5;
				}else if(grade.equals("C0"))
				{
					gradescore=2.0;
				}
				else if(grade.equals("D+"))
				{
					gradescore=1.5;
				}
				else if(grade.equals("D0"))
				{
					gradescore=1.0;
				}
				else if(grade.equals("F0"))
				{
					gradescore=0.0;
				}
				
				credit+=score;
			}
				ans+=gradescore*score;

			
			
		}
		System.out.printf("%.6f",ans/credit);
	}

}
