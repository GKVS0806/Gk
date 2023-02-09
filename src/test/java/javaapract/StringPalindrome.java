package javaapract;

public class StringPalindrome 
{
public static void main(String[] args) 
{
String s="madam",S="";
for(int i=s.length()-1;i>=0;i--)
{
	S=S+s.charAt(i);
}
if(S.equals(s))
{
System.out.println("its a String Palindrome");	
}
else
{
System.out.println("its not a String palindrome");	
}
}
}
