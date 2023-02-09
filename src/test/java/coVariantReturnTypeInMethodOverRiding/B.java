package coVariantReturnTypeInMethodOverRiding;

public class B extends A
{
public B show() // B-return type should be of the same class type
{
System.out.println("class B method");
return this;	// this keyword is used to refer to the current object 
}
public static void main(String[] args) 
{
B b1 = new B();
b1.show();
}
}
