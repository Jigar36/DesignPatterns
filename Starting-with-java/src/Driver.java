import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Created by jigar on 8/30/2016.
 */

/**
 * The class Driver creates an input stream
 * for given file. It is also responsible to read
 * one line of file and store in an array. Also, when the read
 * operation is done, it closes the input stream.
 * It is also responsible for writing output to a output file
 * after processing the course allocation.
 *
 */

public class Driver {

    /**
     * This variables defines the capacity for courses
     * than can allocated students as per their preferences.
     *
     */
    static int courseA = 10;
    static int courseB = 10;
    static int courseC = 10;
    static int courseD = 10;

    /**
     * Array is used to store the input file read from the input.txt, while
     * allocated array is defined to store the courses allocated to students
     * according to their preferences and course array is used to store course
     * name during allocation.
     */

    public static int[][] array = new int[13][5];
    public static int[][] allocated = new int[13][5];
    public static char[][] course = new char[13][5];

    /**
     * This function reads and writes one line from/to a file and calculates
     * course allocation according to the preferences and also handles
     * File not found exception, Number Format Exception and IO exception.
     *
     */
    public static void main(String[] args) {

        int i =1;
        int j;
        Scanner scanner = null;
        try {

            scanner = new Scanner(new BufferedReader(new FileReader(args[0])));
            scanner.useDelimiter(" ");
            while(scanner.hasNextLine()) {

                String input = scanner.nextLine();
                String[] data = input.split(" ");

               // String StudentName = data[0];
                int pref1 = Integer.parseInt(data[1]);
                int pref2 = Integer.parseInt(data[2]);
                int pref3 = Integer.parseInt(data[3]);
                int pref4 = Integer.parseInt(data[4]);

                array[i][0] = 0;
                array[i][1] = pref1;
                array[i][2] = pref2;
                array[i][3] = pref3;
                array[i][4] = pref4;

                i++;

                //uncomment for testing reading of an input file
               // System.out.println(StudentName + ": " + pref1 + " " + pref2+ " " + pref3+ " " + pref4);

            }
        }catch(NumberFormatException e){
            System.err.print("Number value expected");
            e.printStackTrace();
            System.exit(0);
        } catch(FileNotFoundException ex){
            System.err.println("File not found");
            System.exit(-1);
        } finally {
            if(scanner != null) {
                System.out.println("\n File Read complete...");
                scanner.close();
            }
        }

        /**
         * 1 st iteration for allocating 1st course to the students
         * according to the preferences.
         *
         */
        int pref=1;
            for (j = 1; j < array.length; j++) {
               pref=1;
                for (int k = 1; k < array[j].length; k++) {
                    if (array[j][k] == pref) {
                        int retA = courses(k);
                        if (retA == 0) {
                            allocated[j][1] = array[j][k];
                            fill(j,1,k);
                        }
                        else{
                            System.out.println("Course is filled..");
                            k=0;
                            pref++;
                        }
                    }
                }
            }

/**
 * 2 nd iteration for allocating 2nd course to the students
 * according to the preferences.
 *
 */
        int pref1 = 2;
        for (j = 1; j < array.length; j++) {
            pref1 = 2;
            for (int k = 1; k < array[j].length; k++) {
                if (array[j][k] == pref1) {
                    int retA = courses(k);
                    if (retA == 0) {
                        allocated[j][2] = array[j][k];
                        fill(j,2,k);
                    } else {
                        System.out.println("Course is filled..");
                        k = 0;
                        pref1++;
                    }
                }

            }
        }

/**
 * 3 rd iteration for allocating 3 rd course to the students
 * according to the preferences.
 *
 */
        int pref2 = 3;
        for (j = 1; j < array.length; j++) {
            pref2 = 3;
            for (int k = 1; k < array[j].length; k++) {
                if (array[j][k] == pref2) {
                    int retA = courses(k);
                    if (retA == 0) {
                        allocated[j][3] = array[j][k];
                        fill(j,3,k);
                    } else {
                        System.out.println("Course is filled..");
                        k = 0;
                        pref2++;
                    }
                }

            }
        }

        float averageScore=0;
        for(j=1;j<allocated.length;j++){
            allocated[j][4]=allocated[j][1]+allocated[j][2]+allocated[j][3];
            averageScore +=  allocated[j][4];

            // Uncomment for printing the output on the console
            //System.out.println("Student_"+j+" "+allocated[j][1]+" "+allocated[j][2]+" "+allocated[j][3]+" Total "+allocated[j][4]);

        }
        System.out.println("Average preference_Score is: "+averageScore/12);
        System.out.println("Remaining seats for course_A: "+courseA+" course_B: "+courseB+ " course_C: "+courseC+" course_D: "+courseD);

/**
 * Writing data to the output.txt file
 *
 */
        try(FileWriter locFile = new FileWriter(args[1])){
            for(j=1;j<allocated.length;j++) {
                locFile.write("Student_"+j+" Course_"+course[j][1]+" Course_"+course[j][2]+" Course_"+course[j][3]+" Total "+allocated[j][4]+"\n");
            }
            locFile.write("\n Average preference_Score is: "+averageScore/12);
        }
        catch (IOException e) {
            System.err.println("Unable to write to File");
            System.exit(-1);
        }finally {
            System.out.println("\n File Write complete...");
        }
    }

    /**
     * This function is used for checking the availability of the courses
     * before allocating to a student and if available it decrements the
     * count of the seats for the respective course.
     *
     */

    public static int courses(int k){
        //preference 1 allocation
        switch(k){
            case 1:
                if(courseA!=0)
                {
                    courseA--;
                    return 0;
                }
                else{
                    System.out.println("Course A is filled...!");
                      return 1;
                }

            case 2:
                if(courseB!=0)
                {
                    courseB--;
                    return 0;
                }
                else{
                    System.out.println("Course B is filled...!");
                     return 1;
                }

            case 3:
                if(courseC!=0)
                {
                    courseC--;
                    return 0;
                }
                else{
                    System.out.println("Course C is filled...!");
                     return 1;
                }

            case 4:
                if(courseD!=0) {
                    courseD--;
                    return 0;
                }
                else{
                    System.out.println("Course D is filled...!");
                    return 1;
                }
        }
        return -1;
    }

    /**
     * This function allocated the course name when allocated to
     * student.
     *
     */

    public static void fill(int j, int k,int value){
        switch(value) {
            case 1:
                course[j][k] = 'A';
                break;
            case 2:
                course[j][k] = 'B';
                break;
            case 3:
                course[j][k] = 'C';
                break;
            case 4:
                course[j][k] = 'D';
                break;
        }
    }
}
