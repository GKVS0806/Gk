package javaapract;


public class ConversionOfStringToArrray
{
	public static void main(String[] args) 
	{
		String s="Girish";
		char[]S=s.toCharArray();
		for(int i=0;i<S.length;i++)
		{

			S[i]=s.charAt(i);

		}
		System.out.println(S);
		for (char c : S) 
		{
			System.out.println(c);
		}
	}
}
