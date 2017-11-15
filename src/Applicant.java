public class Applicant {

	protected String firstName;
	protected String lastName;
	protected String dob;
	protected int creditScore;
	protected int threeMonthsIncome;
	protected int previousYearTaxableIncome;
	protected int loanAmountRequested;
	
	public Applicant() {}

	public Applicant(String firstName) {
		this.firstName = firstName;
	}

	public Applicant(String firstName, String lastName, String dob, int creditScore, int threeMonthsIncome,
			int previousYearTaxableIncome, int loanAmountRequested) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.creditScore = creditScore;
		this.threeMonthsIncome = threeMonthsIncome;
		this.previousYearTaxableIncome = previousYearTaxableIncome;
		this.loanAmountRequested = loanAmountRequested;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public int getThreeMonthsIncome() {
		return threeMonthsIncome;
	}

	public void setThreeMonthsIncome(int threeMonthsIncome) {
		this.threeMonthsIncome = threeMonthsIncome;
	}

	public int getPreviousYearTaxableIncome() {
		return previousYearTaxableIncome;
	}

	public void setPreviousYearTaxableIncome(int previousYearTaxableIncome) {
		this.previousYearTaxableIncome = previousYearTaxableIncome;
	}

	public int getLoanAmountRequested() {
		return loanAmountRequested;
	}

	public void setLoanAmountRequested(int loanAmountRequested) {
		this.loanAmountRequested = loanAmountRequested;
	}
	
}