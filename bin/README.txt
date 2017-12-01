/*THE CHALLENGE:
 * Create an application that contains information of applicants and their financial information,
 * including the following:
 * Name, Date of Birth, Credit Score, Three-month income statement, Last year's reported taxable
 * income, and the loan amount requested.
 * Note: (I added Loan Term Requested in Months on my own to properly calculate debt-to-income ratio)
 * 
 * Develop the following methods:
 * 1. A method that will make the decision to deny or approve the application based upon the following
 * criteria:
 * 		a. Credit score should be above 600
 * 		b. Debt-to-income ratio cannot exceed 30%
 * 		c. The loan amount should be no more than 5 times the previous year's income
 * 		d. Last three months' income must total at least $12,000
 * 
 * 2. Assign each loan application a unique ID with the following syntax:
 * 		2-digit index + Random letter + First letter of First Name + Random 3-digit number
 * 
 * OUTPUT THE FOLLOWING RESULTS TO THE CONSOLE:
 * 	• The LoanID and the decision (Approve or Deny)
 * 	• If the loan is approved, then output the mortgage value. If the loan is denied, then explain why.
 */