package mulesofttechnicaltest;

import org.mule.api.transport.PropertyScope;

public class LoanMessage implements java.io.Serializable,  Comparable<LoanMessage>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String loanType;
	private double amount;
	private double income;
	private double expenses;
	private int loanDuration;
	private int interest;
	private String applicationId;

	 private String email;
	
	//default constructor
	public LoanMessage()
	{
		
	}
	public LoanMessage(String type, String email, double amount, double income, double expenses,
	int loanDuration, int interest)
    {
    	this.amount = amount;
    	this.email = email;
    	this.loanDuration = loanDuration;
    	this.loanType = type;
    	this.expenses = expenses;
    	this.interest = interest;
	}
	
	public String getLoanType()
	{
		return loanType;
	}

	void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	double getAmount() {
		return amount;
	}

	void setAmount(double amount) {
		this.amount = amount;
	}

	double getIncome() {
		return income;
	}

	void setIncome(double income) {
		this.income = income;
	}

	double getExpenses() {
		return expenses;
	}

	void setExpenses(double expenses) {
		this.expenses = expenses;
	}

	int getLoanDuration() {
		return loanDuration;
	}

	void setLoanDuration(int loanDuration) {
		this.loanDuration = loanDuration;
	}

	int getInterest() {
		return interest;
	}

	void setInterest(int interest) {
		this.interest = interest;
	}
	@Override
	public int compareTo(LoanMessage o) {
		// TODO Auto-generated method stub
		return 0;
	}
	public String getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(String applicationId) {
		this.applicationId = applicationId;
	}
	String getEmail() {
		return email;
	}
	void setEmail(String email) {
		this.email = email;
	}
	
	public Boolean GetLoanEligibility()
	{
		double monthlyDisposable = (getIncome() - getExpenses())/12;
		int totalYears = getLoanDuration()/12;
		
		double applicableInterest = (getAmount() * getInterest() /100)*totalYears;
		double totalAmount = getAmount()+applicableInterest;
		double emi = totalAmount / getLoanDuration();
		System.out.println("Disposable amount - "+ monthlyDisposable);
		System.out.println("Total emi is -"+emi);
		Boolean loanEligibility = monthlyDisposable > emi;
		return loanEligibility;
	}
	
}
