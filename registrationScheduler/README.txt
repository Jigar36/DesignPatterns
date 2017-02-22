CS542 Design Patterns
Fall 2016
PROJECT 2 README FILE

Due Date: Friday, September 30, 2016
Submission Date: September 30, 2016
Grace Period Used This Project: 0 Days
Grace Period Remaining: 0 Days
Author(s): Jigar Panchal
e-mail(s): jpancha1@binghamton.edu


PURPOSE:
Application of design principles for a simple multi-threaded application 
for assigning courses to students according to their preferences and 
calculating the average preference score.

PERCENT COMPLETE:
I believe I have completed 100% of this project.

PARTS THAT ARE NOT COMPLETE:
None.

BUGS:
None.

FILES:
Included with this assignment are 10 files:

1) Driver.java, the file has main function and does the desired functions' call.
2) CreateWorkers.java, the file spwans threads.
3) WorkerThread.java, the file includes run method of the thread and reads line from file.
4) Results.java, the file has Data Structure to store list of courses allocated and calulates 
	the average preference score.
5) StdoutDisplayInterface.java, an interface to print contents of result's data structure to the screen.
6) FileDisplayInterface.java, , an interface to write contents of result's data structure to the file.
7) FileProcessor.java, reads a line from a given file.
8) AllocateCourse.java stores the algorithm for allocating courses according to the student preferences.
9) CoursePool.java uses a singleton pattern which stores the counter of the courses to borrow 
	and return courses when requested by the AllocateCourse.java.
10) Logger.java, logs messages for debugging purposes.
11) build.xml, ANT configuration for compiling the code.


SAMPLE OUTPUT:

remote01:~/jigar_panchal_assign2/registrationScheduler> ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0
Buildfile: /import/linux/home/jpancha1/jigar_panchal_assign2/registrationScheduler/src/build.xml

jar:
    [mkdir] Created dir: /import/linux/home/jpancha1/jigar_panchal_assign2/registrationScheduler/BUILD/jar
      [jar] Building jar: /import/linux/home/jpancha1/jigar_panchal_assign2/registrationScheduler/BUILD/jar/registrationScheduler.jar

run:
     [java] The average preference value is: 19.9625
     [java] 
     [java]  File Write complete...

BUILD SUCCESSFUL
Total time: 1 second


TO COMPILE:

On terminal,
1) Go to registrationScheduler folder.
2) Type 'ant -buildfile src/build.xml clean' and press Enter.
3) Type 'ant -buildfile src/build.xml all' to compile and press Enter.

TO RUN:

1) Type 'ant -buildfile src/build.xml run -Darg0=input.txt -Darg1=output.txt -Darg2=3 -Darg3=0' and press Enter


JUSTIFICATION FOR DATA STRUCTURE USED:
The Data Structure used in this project is ArrayList, as it has a better space complexity.
i.e: it grows by 50% while the vector grows by double size.
Therefore As vector has space complexity higher than ArrayList and ArrayList can be easily
used in multithreaded environment by making the method to add data as synchronized.


EXTRA CREDIT:

none

BIBLIOGRAPHY:

none 




