package javaapract;

import java.util.Scanner;

public class PrintNum_ToWord
{
public static void main(String[] args) 
{
	String [] s= {"one","two","Three","Four","Five","Six","seven","eight","nine","ten"}	;
	Scanner sc = new Scanner(System.in);
	System.out.println("enter the num value");
	int num=sc.nextInt();
System.out.println(s[num-1]);
}
}
