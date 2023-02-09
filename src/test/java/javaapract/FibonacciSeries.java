package javaapract;

public class FibonacciSeries
{
public static void main(String[] args) 
{
int sum=0,n1=0,n2=1;
System.out.print(" "+n1);
System.out.print(" "+n2);
for (int i = 0; i < 10; i++) 
{
sum=n1+n2;
n1=n2;
n2=sum;
System.out.print(" "+sum);
}
}
}
