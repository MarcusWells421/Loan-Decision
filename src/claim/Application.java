package claim;
import java.util.Scanner;

import claim.utils.Utilities;

public class Application{

/* SEE README FILE FOR AN EXPLANATION OF THE CHALLENGE*/
	final static int APPLICANT_DATA_SIZE = 8;
	public static void main(String[] args) {
//Prompt the user for the applicant's information
		Scanner input = new Scanner(System.in);
		
		String[] info = new String [APPLICANT_DATA_SIZE];
	try {
		do {
		System.out.println("Welcome to LoanSmart! All of the applicant's information must be entered "
				+ "on one line, separated by commas.\r\nPlease enter the applicant's information"
				+ "in the following order: \r\n\r\n"
				+ "First Name\r\nLast Name\r\nDate of Birth\r\nCredit Score\r\n"
				+ "Most Recent 3 Months' Income\r\nLast year's reported taxable income\r\n"
				+ "Loan Amount Requested\r\nLoan Term Requested (Months)\r\n");
		String data = input.nextLine();
		String delimiter = "[,]+";
		info = data.split(delimiter);
//Verify that all 8 data fields were entered by the user. If not, prompt the user to re-enter the info.
		System.out.println(info.length);
			if(info.length < APPLICANT_DATA_SIZE) {
				System.out.println("Error! Data is missing. Please try again.\r\n\r\n");
			} else {
//Now that we've verified that all fields were completed, create the applicant object.
				Applicant applicant = new Applicant();
				applicant.setFirstName(info[0].trim());
				applicant.setLastName(info[1].trim());
				applicant.setDob(info[2].trim());
				applicant.setCreditScore(Integer.parseInt(info[3].trim()));
				applicant.setThreeMonthsIncome(Integer.parseInt(info[4].trim()));
				applicant.setPreviousYearTaxableIncome(Integer.parseInt(info[5].trim()));
				applicant.setLoanAmountRequested(Integer.parseInt(info[6].trim()));
				applicant.setLoanTermRequestedInMonths(Integer.parseInt(info[7].trim()));
				
//Generate Loan Decision
				System.out.println("For Loan Application Number " + Utilities.generateLoanId(applicant)
					+ "(" + applicant.getLastName() + ", " + applicant.getFirstName() + ", DOB "
					+ applicant.getDob() + "):");
				Utilities.loanDecision(applicant);			}
		} while (info.length < APPLICANT_DATA_SIZE);
	} catch (Exception e) {
		System.out.println("There was an error! Please try again.");
		input.close();
		return;
	}
		input.close();	
	}

}