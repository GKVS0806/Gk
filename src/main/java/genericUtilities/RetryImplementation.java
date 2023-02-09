package genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryImplementation implements IRetryAnalyzer// functional interface which consists of only one abstract method
{
    int maxRetries=3;
    int count;
	@Override
	public boolean retry(ITestResult result) {
		if(count<maxRetries)
		{
			count++;
			return true;
		}
		return false;
	}

}
