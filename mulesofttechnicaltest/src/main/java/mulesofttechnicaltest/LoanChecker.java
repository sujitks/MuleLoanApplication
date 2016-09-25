package mulesofttechnicaltest;

import java.util.Map;
import org.mule.api.MuleEventContext;
import org.mule.api.MuleMessage;
import org.mule.api.lifecycle.Callable;
import org.mule.api.transport.PropertyScope;
import org.apache.log4j.Logger;

public class LoanChecker implements Callable {

	private static Logger logger = Logger.getLogger(LoanChecker.class);
	
	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {
		// TODO Auto-generated method stub
		MuleMessage message = eventContext.getMessage();
		LoanMessage lm = (LoanMessage)message.getPayload();
		logger.info("start setting up the message properties");
		if(lm!=null)
		{
				setLoanType(lm, message);
				setLoanEligibility(lm, message);
				setEmailProperty(lm, message);
	
		}
		
		return message;
	}
	
	private void setEmailProperty(LoanMessage loanMessage, MuleMessage muleMessage)
	{
		muleMessage.setProperty("email", loanMessage.getEmail(), PropertyScope.OUTBOUND);
		
	}
	
	private void setLoanType(LoanMessage loanMessage, MuleMessage muleMessage)
	{
		
		muleMessage.setProperty("loanType", loanMessage.getLoanType().toLowerCase(), PropertyScope.OUTBOUND);
		
	}
	
	private void setLoanEligibility(LoanMessage loanMessage, MuleMessage muleMessage)
	{
		muleMessage.setProperty("loanEligibility", loanMessage.GetLoanEligibility(), PropertyScope.OUTBOUND);
	}

}
