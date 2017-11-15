import java.text.NumberFormat;

public class Application {

	public static void main(String[] args) {
		Applicant applicant = new Applicant();
//Set your applicant's information
		applicant.setFirstName("Joey");
		applicant.setLastName("TestCase");
		applicant.setDob("06/24/1988");
		applicant.setCreditScore(700);
		applicant.setThreeMonthsIncome(12000);
		applicant.setPreviousYearTaxableIncome(46000);
		applicant.setLoanAmountRequested(200000);

//Generate Loan Decision
		System.out.println("For Loan Application Number " + generateLoanId(applicant)
			+ "(" + applicant.getLastName() + ", " + applicant.getFirstName() + ", DOB "
			+ applicant.getDob() + "):");
		loanDecision(applicant);
		
	}

	public static String generateLoanId(Applicant applicant) {
		String firstLetterFirstName = applicant.getFirstName().trim().substring(0, 1).toUpperCase();
		String randomLetter = ((char)((int)(Math.random() * ((90 - 65) + 1) + 65)) + "").toString();
		int random = (int)(Math.random() * ((999 - 0) + 1) + 0);
		String randomThreeDigits = String.format("%03d", random);
		IndexGen x = new IndexGen();
		int count = IndexGen.index;
		String index = String.format("%02d", count);
		return index+randomLetter+firstLetterFirstName+randomThreeDigits;
	}

//Determine credit eligibility
	public static String credit(int score) {
		return (score > 600 ? "" : "Credit score below minimum");
	}
//Calculate debt-to-income ratio
	public static String dti(int loanAmountRequested, int threeMonthsIncome) {
		return (loanAmountRequested/(threeMonthsIncome/3))/100 <= 0.3 ? "" : "Debt-to-income ratio exceeds the maximum allowable.";
	}
//Calculate loan to income criteria
	public static String lti(int loanAmountRequested, int previousYearTaxableIncome) {
		return (loanAmountRequested <= (5 * previousYearTaxableIncome) ? "" : "Loan to income ratio exceeds the maximum allowable.");
	}
//Determine if minimum income requirement is met
	public static String minIncome(int threeMonthsIncome) {
		return (threeMonthsIncome >= 12000 ? "" : "Current income does not meet minimum requirements.");
	}
//Deliver the loan decision to the console
	public static void loanDecision(Applicant applicant) {
		NumberFormat usd = NumberFormat.getCurrencyInstance();
		int score = applicant.getCreditScore();
		int income = applicant.getThreeMonthsIncome();
		int lastYear = applicant.getPreviousYearTaxableIncome();
		int loanAmt = applicant.getLoanAmountRequested();
		if(credit(score) == "" && dti(loanAmt, income) == "" && lti(loanAmt, lastYear) == "" && minIncome(income) == "")
			{
				System.out.println("Applicant is APPROVED for a loan of " + usd.format(loanAmt) + "!\r\nThis approval is valid for up to 90 calendar days from the application date.");
			} else {
				System.out.println("Loan application declined. Reasons for declination:");
				String credit = credit(score);
				String dti = dti(loanAmt, income);
				String lti = lti(loanAmt, lastYear);
				String minIncome = minIncome(income);
				if(credit != "") {
					System.out.println(credit); 
				}
				if (dti != "") {
					System.out.println(dti);
				}
				if (lti != "") {
					System.out.println(lti);
				}
				if (minIncome != "") {
					System.out.println(minIncome); 
				}

			}
	}
}
