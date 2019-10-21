Feature: Way2sms Login functionality
  @smoketest
  Scenario: Login
  
	Given launch site
	When enter mobile no as 76874864149
	And enter password
	And click on login button
	And close site

Scenario: login along with data
                                  
	Given launch site
	When enter mobile no as "7674864149"
	And enter password as "leela1993"
	And click on login button
	And close site
	
	Scenario Outline: validating login along with examples
  
  Given launch site
	When enter mobile no as "<mobileno>"
	And enter password as "<password>"
	And click on login button
	Then validate login functionality with "<mobilenocriteria>" and "<passwordcriteria>" 
	And close site
	 
	Examples:
	| mobileno |mobilenocriteria| password|passwordcriteria|
	|7674864149|  valid         |leela1993|     valid      |
	|          |    blank       |leela1993|     valid      |
	|7674864140|    invalid     |leela1993|     valid      |
	|767486414 |    wrongsize   |leela1993|     valid      |
	|7674864149|    valid       |         |     blank      |
	|7674864149|    valid       |leela1994|     invalid    |
  
  Scenario:
  
  Given launch site
	When enter mobile number
	| mobileno |
	|7674864149|
	|          |
	|7674864140|
	|767486414 |
	And enter password as
	| password|
	|         |
	|leela1994|
	And click on login button
	Then validate login functionality with mobilenocriteria and passwordcriteria 
	|mobilenocriteria|passwordcriteria|
	|  valid         |  valid         |
	|    blank       |valid           |
	|    invalid     |valid           |
	|    wrongsize   |valid           |
	| valid          |blank           |
	|  valid         |invalid         |
	And close site
