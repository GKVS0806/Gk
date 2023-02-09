package dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PracticeTest 
{
	@Test(dataProvider="dataForTicketBooking")
public void bookTicketTest(String source, String dest)
{
System.out.println("from:"+source+"\t"+"To:"+dest);	
}
@DataProvider
public Object[][] dataForTicketBooking()
{
Object[][] obj=new Object[3][2];
obj[0][0]="Bangalore";
obj[0][1]="Hyderabad";

obj[1][0]="kashmir";
obj[1][1]="Kanyaakumari";

obj[2][0]="kerala";
obj[2][1]="karnataka";

return obj;
}
}
