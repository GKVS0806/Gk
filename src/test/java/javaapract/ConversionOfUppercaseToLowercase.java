package javaapract;

public class ConversionOfUppercaseToLowercase
{
public static void main(String[] args) 
{
String s="GirisH";
int count=0;
for (int i = 0; i < s.length(); i++)
{
if(s.charAt(i)>='A'&&s.charAt(i)<='Z')
{
count++;
}
}
System.out.println("The count of uppercase letters in the given string are "+count);
System.out.println("coonverted from uppercase to lowercase is as followed "+s.toLowerCase());
}
}
