# Exercises

## What You Should Know About Testing
Project: [basics](basics)
* Write Tests for ```ExceptionThrower.throwRuntimeException()```. 
  * Verify that the correct error message is thrown based on the given parameter value.
* Write a Test for ```ExceptionThrower.throwExceptionWithCause()```. 
  * Verify the chained (cause) exception.

## Hamcrest Matchers
Project: [hamcrest](hamcrest)
1. Write a Test for ```com.zuehlke.testing.hamcrest.Person``` using Hamcrest Matchers to verify all the fields. 
2. Open ```com.zuehlke.testing.hamcrest.exercises.CollectionTest``` and write the asserts that are described in the comments
3. Implement a TypeSafeDiagnosingMatcher for first name and a FeatureMatcher for last name and use them to test ```com.zuehlke.testing.hamcrest.Person```.

## JUnit Extensions
Project: [extensions-rules](extensions-rules)
* Write an Extension that produces the following output when added to ```com.zuehlke.testing.rules.exercises.PersonTest```
  ```
  com.zuehlke.testing.rules.exercises.PersonTest: constructor_parameterNull_exceptionThrown()
  com.zuehlke.testing.rules.exercises.PersonTest: constructor_parametersGiven_initializedPerson()
  com.zuehlke.testing.rules.exercises.PersonTest: constructor_parameterEmptyString_initializedPerson()
  ```
* Write a Test for LogWriter.log using the TempDir Extension to create a logfile and verify that the message is written to the file.

## Testdata Management
Project: [testdata](testdata)
* Write two Parameterized Tests for ```PrimeFactor.isPrime()``` 
  * one with parameters as part of the annotation (CSVSource)
  * one with parameters coming from a method source
  *	use a custom display text for both tests and the individual executions

## Organising Tests
Project: [organising-tests](organising-tests)

Create a new Test with Tag “SuperFast” and change the build.gradle of the module organising-tests so that this SuperFast Test is also executed.

Hint: 

Only executing tests in a submodule with gradle wrapper:
```
.\gradlew :organising-tests:test
.\gradlew -p organising-tests test
```
Executed Tests can be seen in the console or here:
```
....\organising-tests\build\test-results\test
```

## Code Coverage
Project: [code-coverage](code-coverage)

### Coverage types
The following exercise is based on the class ```com.zuehlke.testing.coverage.example.CoverageExampleFromSlide```.
1. Write a test class with tests that achieve Method Coverage
2. Write a test class with tests that achieve Statement Coverage
3. Write a test class with tests that achieve Branch Coverage
4. Write a test class with tests that achieve Multiple-Condition Coverage

### Vending Machine
* Write test cases for the ```com.zuehlke.testing.coverage.vendingmachine.VendingMachine``` class
* Try to identify and fix bugs
* Use Coverage to find code areas not covered by your tests

## Test Doubles
Project: [test-doubles](test-doubles)

```com.zuehlke.testing.testdoubles.excercise.TelephoneTest#testCall_busy_forwardToVoiceMail()``` has code that is commented out. Implement VoiceMailServiceSpy with the missing functionality, so that the code in ```testCall_busy_forwardToVoiceMail()``` can be activated and the test successfully run.

## Mockito
Project: [mockito](mockito)

```PersonService``` uses the class ```PersonDao``` to access a database.

To write Unit Tests without dependencies to or a running database, ```PersonDao``` needs to be mocked with Mockito.
* **Return Value:** 
  * Write a Test that returns a valid person for a call to the method ```findById(1)```.
  * What happens if you call ```findById(2)```?
* **Exception:** 
  * Write a Test that verifies valid ids. For negative ids an ```IllegalArgumentException``` should be thrown.
* **Verify Method Called:** 
  * Write a Test that verifies if a method was called on the Mock. E.g. ```PersonDAO.findAll()```.
* **Call Count:** 
  * Write a Test that verifies the number of calls for the following code snippet for ```findById()``` and ```findAll()``` – check only for id 1 for exact match.
  ````
  // Act
  testee.findById(11);
  testee.findAll();
  testee.findById(1);
  testee.findById(2);
  ````  
 
Hint: Use ```anyInt()``` as placeholder for ```findById()```.

## JUnit 5
Project: [junit5](junit5)

1. Write a Test that fails if a timeout occurs
2. Create ```HashCodeContract``` with relevant methods and tests and use it in ```StringTests```
3. Create a ```ParameterizedTest``` injecting ```TestReporter``` and ```TestInfo``` into the test method. 

## Test Driven Development
Project: [test-driven-development](test-driven-development)

* Create a String calculator with method the following method signature: ```public int add(String values)```
* The method takes a String containing 0, 1 or 2 comma-separated numbers and will return the sum
* For an empty string it will return 0
* Example inputs: “”, “5”, “36,8” 
* adding 3 and more numbers throws an IllegalArgumentException

## Legacy Code
Project: [legacy-code](legacy-code)

**Gilded Rose**

You are hired by the Inn Gilded Rose to extend their current inventory system to handle Conjured items. After taking a look at the code, you decide to do some refactoring first, so that you are sure you add the functionality in the right place without breaking the functionality handling the other items.
You can find the requirements in the _GildedRoseRequirements.txt_ file, which is in the legacy-code module.

To make refactoring and writing tests a bit easier, a ```GoldenMasterTest``` is provided. It contains a scenario with a variety of items and runs for 31 days, collecting the state of the system for every day and comparing it to the original state in ```GoldenMaster.txt```. Do run this test first, if it fails you may need to change the **LINE_SEPARATOR** on line 16 from **"\n"** to **"\r\n"**.

To get you started a first pin down test already exists: ```com.gildedrose.GildedRoseTest#standardItem_SellInPast_QualityDegradesTwiceAsFast()```

Write additional tests and refactor as you go along.

**Summary:**

Look at the Requirements and use the GoldenMasterTest as an additional check to verify your changes.
* Write Pindown tests
* Refactor code so that it is understandable
* Update the algorithm to correctly handle “Conjured” items
