package javaapract;

public class ToCheckHowManyAreUppercaseAndLowerCase
{
public static void main(String[] args) 
{
String s="GirishKumarVs";	
int uc=0,lc=0;
for (int i = 0; i < s.length(); i++) 
{
	if(s.charAt(i)>'A'&&s.charAt(i)<'Z')
	{
		uc++;
	}
	else if(s.charAt(i)>'a'&&s.charAt(i)<'z')
	{
		lc++;
	}
}
System.out.println("the count of uppercase characters in the given stirng are "+uc);
System.out.println("the count of uppercase characters in the given stirng are "+lc);
}
}
