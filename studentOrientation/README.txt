CS542 Design Patterns
Fall 2016
PROJECT 3 README FILE

Due Date: Friday, October 27, 2016
Submission Date: October 27, 2016
Grace Period Used This Project: 0 Days
Author(s): Jigar Panchal, Pranav Bhandari
e-mail(s): jpancha1@binghamton.edu, pbhanda1@binghamton.edu


PURPOSE:
To develop a tool for student orientation program at Binghamton University.

Design Pattern Used: 
Builder pattern.

PERCENT COMPLETE:
I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
None.

BUGS:
None.

FILES:
Included with this assignment are 10 files:

1) Driver.java, the file has main function and does the desired functions' call.
2) Books.java, An interface which stores bookStore methods.
3) CampusTour.java, An interface which stores CampusTour methods.
4) CourseRegistration.java, An interface which stores CourseRegistration methods.
5) DomeSelection.java, An interface which stores DomeSelection methods.
6) OrientationBuilderInterface.java, An interface which stores methods for construction.
7) OrientationBuilder.java, a class which implements all the methods of OrientationBuilderInterface.
8) StudentAbstractClass.java, it has abstract methods as well as it implements books, CampusTour, DomeSelection and 					CourseRegistratrionInterface.
9) Student.java, it extends StudentAbstractClass and implements all its methods.
10) Bookstr.java, stores the enums for UniversityBookStore and MandoBookStore type.
11) CampusVisit.java, store enums for 2 types of CampusTours.
12) CourseReg.java, stores enums for 2 ways of course registration.
13) DoemSel.java, stores enums for 2 ways of dorm selection.
14) ResultsInterface.java, an interface which stores store results methods.
15) Results.java, implements methods of ResultsInterface for storing and printing the values.
16) CarbonFootPrint.java, an interface.
17) CarbonFootPrintClass.java, implements an interface and its methods for calculating co2 consumed.
18) Cost.java, an interface.
19) CostClass.java, implements an interface and its methods for calculating cost.
20) Duration.java, an interface.
21) DurationClass.java, implements an interface and its methods for calculating Duration taken.
22) Efforts.java, an interface.
23) EffortsClass.java, implements an interface and its methods for calculating efforts taken.
24) build.xml, ANT configuration for compiling the code.


SAMPLE OUTPUT:

remote02:~/studentOrientation> ant -buildfile build.xml run
Buildfile: /import/linux/home/jpancha1/studentOrientation/build.xml

jar:
    [mkdir] Created dir: /import/linux/home/jpancha1/studentOrientation/BUILD/jar
      [jar] Building jar: /import/linux/home/jpancha1/studentOrientation/BUILD/jar/studentOrientation.jar

run:
     [java] Total Duration : 255 minutes
     [java] Total Effort : 1020 Calories
     [java] Total carbonFootprint : 2400 CO2
     [java] Total Cost : $40025.1

BUILD SUCCESSFUL
Total time: 1 second



TO COMPILE:

On terminal,
1) Go to studentOrientation folder.
2) Type 'ant -buildfile build.xml clean' and press Enter.
3) Type 'ant -buildfile build.xml all' to compile and press Enter.

TO RUN:

1) Type 'ant -buildfile build.xml' and press Enter




EXTRA CREDIT:

none

BIBLIOGRAPHY:

none 




