#Readme
#The attached project tests the UI acceptance criteria

 - Please open the pom file as maven project, 

 - Please include latest chromedriver.exe in following path - /src/test/java/co/uk/valtech/utils/drivers/

 - Feature File Path: /src/test/resources/features

 - If Opened with IntelliJ, Run with RunCukes or run from feature file

#Screenshot Capture 
- If Failure of Test case occurs, Screenshots are captured under the folder - /src/test/java/co/uk/valtech/screenshots

# How to run
Go to root directory
  - COMMAND LINE RUN : mvn clean test (This Command is used in the any CI/CD Pipeline setup)

Run from IDE tool
  - go to /src/test/java/co/uk/valtech/runcukes/RunCukes.java and click Run
  - or
  - go to /src/test/resources/features/ValtechExercriseValidation.feature, Right on Click on Feature and Click Run
    "Feature: ValtechExercriseValidation"


#Framework
- Cucumber
- Java
- BDD
- Selenium
    - Page Object Model
    - Page Factory

