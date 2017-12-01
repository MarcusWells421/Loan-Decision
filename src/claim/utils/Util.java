package claim.utils;

public class Util {

	// Determine credit eligibility
	protected static String credit(int score) {
		return (score > 600 ? "" : "Credit score below minimum.");
	}

	// Calculate debt-to-income ratio
	protected static String dti(int loanAmt, int loanTermRequestedInMonths, int threeMonthsIncome) {
		double monthlyIncome = threeMonthsIncome / 3;
		double monthlyPayment = loanAmt / loanTermRequestedInMonths;
		double dti = monthlyPayment / monthlyIncome;
		return dti <= .3 ? "" : "Debt-to-income ratio exceeds the maximum allowable.";
	}

	// Calculate loan to income criteria
	protected static String lti(int loanAmountRequested, int previousYearTaxableIncome) {
		return (loanAmountRequested <= (5 * previousYearTaxableIncome) ? ""
				: "Loan to income ratio exceeds the maximum allowable.");
	}

	// Determine if minimum income requirement is met
	protected static String minIncome(int threeMonthsIncome) {
		return (threeMonthsIncome >= 12000 ? "" : "Current income does not meet minimum requirements.");
	}

}
