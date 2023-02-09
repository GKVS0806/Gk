package javaapract;

public class Tocheckvowels
{
public static void main(String[] args)
{
String str="welcome";
int count=0;
for(int i=0;i<str.length();i++)
{
if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u')
{
count++;
}
}
if(count>1)
{
System.out.println("true" + " and the number of vowels present in the given string is "+count);
}
else
{
System.out.println("false");
}
}
}
