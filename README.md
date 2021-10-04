# CodingExercises

Functionality with Classes Name : 

1)CodingApplication.java is the main class to run the application

2)CsvReaderService.java is the responsible for reading and parsing csv file  

3)CalcaulateUserTrips.java will calculate user trips and prepare data for output trips. 
  Separate calculation comments mentioned inside the class

4)CsvWriterService.java will write the csv file with calculated values.

5)FileReaderConstant.java have all the constant vlues.

6)Test classes:
  CalculateUserTripsTest.java
  CsvReaderServiceTest.java
  CsvWriterServiceTest.java

user input trips stored in user_input.csv

calculated values will be written in user_output.csv

all the test classes located inside test directory  

Assumption and key notes:

1)I considered only two records for this exercises to make timeline in mind offcourse we can scale this and some changes required to make that happen.

2)While implementing functionality what I obeserved that I able to write in output csv file but to verify that we need to open output csv file from source code directory not from IDE.

3)I added lombok dependancy but was not working somehow.

4)Intially I was thinking to write controller class to upload csv file and later I removed that and stick with simple java application.
