Code Review Comments
==
- For `HotelBookingTest`: 
    - Duplicate method `setDriverPath()` defined in all Test Classes
    - Test is incomplete, clicks on Search hotels button without entering Check In and Check Out Date
    - Test Method missing assertion
    - Initialization of WebElements missing (`PageFactory.initElements(...)`), hence, WebElements declared using `@FindBy` won't get initialized
- For `FlightBookingTest`:
    - Locators specified in test methods, which make the Test Method difficult to read, manage and maintain
    - Test Class doesn't follow any design pattern
    - Usage of asynchronous wait `Thread.sleep`
    - Unreadable xpath used for departure date, xpath could be shortened to correctly identify the particular date
    - Duplicate method `setDriverPath()` defined in all Test Classes
- For `SignInTest`:
    - Same Top three comments as in `FlightBookingTest`
    - Duplicate method `setDriverPath()` defined in all Test Classes
- Test steps logging is needed
- Test Report should be generated after Test Suite execution


Improvements/Refactoring
=
- Page Object Layer created which has page classes and helper methods related to respective pages
- Test Layer(TestNG Test Classes) calls helper methods of page classes using Objects of Page classes to navigate through AUT
- Assertions present only in Test Layer
- Added browser-specific desired capabilities
- Supports parallel execution based on Test Classes when executed through *testng.xml* added in root directory
- Added only Fluent Wait to handle web elements that takes time to load
- Extent Report used to generate HTML report after end of test suite execution. After test execution, report will be generated in path *test-output/Flights and Hotels Bookings test report.html* in the project root folder
- Log4j used to output the test log into the console
- Added Screenshot utility, that captures the screenshot whenever any test step of a test case fails. Screenshots are generated in *test-output/ErrorScreenshots* folder
