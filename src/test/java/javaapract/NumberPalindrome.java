package javaapract;

public class NumberPalindrome
{
public static void main(String[] args) 
{
int num=1221, sum=0, temp = num, rem=0;
while(num>0)
{
rem=num%10;
sum=(sum*10)+rem;
num=num/10;

}
if(sum==temp)
{
System.out.println("its a palindrome number");	
}
else
{
	
	System.out.println("its  not a palindrome number");}
}
}
