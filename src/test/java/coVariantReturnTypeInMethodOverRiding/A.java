package coVariantReturnTypeInMethodOverRiding;

public class A 
{

	public A show() // A-return type should be of the same class type
	{
		System.out.println("class A method");
		return this; // this keyword is used to refer to the current object
		 
	}
}
