package claim.utils;
import java.text.NumberFormat;

import claim.Applicant;
import claim.IndexGen;

public class Utilities extends Util{
//Generate LoanID
		public static String generateLoanId(Applicant applicant) {
			String firstLetterFirstName = applicant.getFirstName().trim().substring(0, 1).toUpperCase();
			String randomLetter = ((char)((int)(Math.random() * ((90 - 65) + 1) + 65)) + "").toString();
			int random = (int)(Math.random() * ((999 - 0) + 1) + 0);
			String randomThreeDigits = String.format("%03d", random);
			IndexGen x = new IndexGen();
			int count = IndexGen.index;
			String index = String.format("%02d", count);
			return index + randomLetter + firstLetterFirstName + randomThreeDigits;
		}


//Deliver the loan decision to the console
		public static void loanDecision(Applicant applicant) {
			NumberFormat usd = NumberFormat.getCurrencyInstance();
			String credit = credit(applicant.getCreditScore());
			String dti = dti(applicant.getLoanAmountRequested(), applicant.getLoanTermRequestedInMonths(), applicant.getThreeMonthsIncome());
			String lti = lti(applicant.getLoanAmountRequested(), applicant.getPreviousYearTaxableIncome());
			String minIncome = minIncome(applicant.getThreeMonthsIncome());
			
			if(credit == "" && dti == "" && lti == "" && minIncome == "")
				{
					System.out.println("Applicant is APPROVED for a loan of " + usd.format(applicant.getLoanAmountRequested())
					+ "!\r\nThis approval is valid for up to 90 calendar days from the approval date.");
				} else {
					System.out.println("Loan application declined. Reasons for declination:");
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