# Selenium

There are mainly 4 types of waits in selenium -

1. Sleeep : This is very hard wait. Example, ' Thread.sleep(5000)' 
2. Implicit wait: It is to tell selenium to wait for certain time before it throws exception.
Implicit wait is valid for the life of the webdriver.
3. Explicit wait: Explicit wait is to tell the selenium/driver to wait certain time until certain condition occurs before throwing the exception.
4. Fluent wait: Fluent wait is to tell the selenium/driver to wait maximum amount of time for certain condition


### How to run test

Run entire test suite

`mvn clean test`

To run individual feature file

`mvn clean test -Dcucumber.features="path/to/the/file.feature"`

To run