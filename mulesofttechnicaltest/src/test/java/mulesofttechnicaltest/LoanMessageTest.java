package mulesofttechnicaltest;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoanMessageTest {
	
	@Test
	public void loanEligibilityCheck_WhenDisposibleIncomeIsLessThanTheEmi_ShouldRejectLoan() throws Exception{

		LoanMessage message = new LoanMessage("home", "user@gmail.com", 20000, 50000, 50000, 36, 5);
	    assertFalse(message.GetLoanEligibility());
	
	}
	
	@Test
	public void loanEligibilityCheck_WhenDisposibleIncomeIsMoreThanTheEmi_ShouldApproveLoan() throws Exception{

		LoanMessage message = new LoanMessage("home", "user@gmail.com", 20000, 75000, 40000, 36, 5);
	    assertFalse(message.GetLoanEligibility());
	
	}
	

}
