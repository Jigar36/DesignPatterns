package registrationScheduler.store;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class Results implements StdoutDisplayInterface, FileDisplayInterface {

	private List<Integer> pref1 = new ArrayList<Integer>();
	private List<Integer> pref2 = new ArrayList<Integer>();
	private List<Integer> pref3 = new ArrayList<Integer>();
	private List<Integer> pref4 = new ArrayList<Integer>();
	private List<Integer> pref5 = new ArrayList<Integer>();
	private List<Integer> total = new ArrayList<Integer>();

	private double sum = 0;

	public Results() {
		Logger.writeMessage("In Result's Constructor.", DebugLevel.CONSTRUCTOR);
	}

	/**
	 * This method calculates the average preference score of the preferences
	 * allocated to 80 students from preferences stored in an ArrayList and
	 * displays contents of data structure on the screen.
	 * 
	 * @param nothing.
	 * @return nothing.
	 */
	@Override
	public void writeToScreen() {

		int k = 0;
		for (int i = 0; i < total.size(); i++) {

			k = i + 1;
			Logger.writeMessage("Student_" + k + ": Course_" + fill(pref1.get(i)) + " Course_" + fill(pref2.get(i))
					+ " Course_" + fill(pref3.get(i)) + " Course_" + fill(pref4.get(i)) + " Course_"
					+ fill(pref5.get(i)) + " total = " + total.get(i), DebugLevel.DATASTRUCTURECONTENT);

			sum += total.get(i);
		}

		// System.out.println("sum is: " + sum);

		Logger.writeMessage("The average preference value is: " + sum / 80, DebugLevel.AVERAGEPREFERENCESCORE);
	}

	/**
	 * This method writes to file the contents of data structure stored in an
	 * ArrayList.
	 * 
	 * @param Output
	 *            file name passed from an argument.
	 * @return nothing.
	 */
	@Override
	public void writeSchedulesToFile(String outputFileNameIn) {
		int k = 0;

		try (FileWriter locFile = new FileWriter(outputFileNameIn)) {
			for (int i = 0; i < total.size(); i++) {
				k = i + 1;
				locFile.write("Student_" + k + ": Course_" + fill(pref1.get(i)) + " Course_" + fill(pref2.get(i))
						+ " Course_" + fill(pref3.get(i)) + " Course_" + fill(pref4.get(i)) + " Course_"
						+ fill(pref5.get(i)) + " total = " + total.get(i) + "\n");
			}
			locFile.write("\n\n The average preference value is: " + sum / 80);
		} catch (IOException e) {
			System.err.println("Unable to write to File");
			System.exit(-1);
		} finally {
			System.out.println("\n File Write complete...");
		}
	}

	/**
	 * This method maps the course character to the allocated course
	 * preferences.
	 * 
	 * @param allocated
	 *            preference Number.
	 * @return Respective Character to the allocated preferences.
	 */
	public char fill(int value) {
		switch (value) {
		case 1:
			return 'A';

		case 2:
			return 'B';

		case 3:
			return 'C';

		case 4:
			return 'D';

		case 5:
			return 'E';

		case 6:
			return 'F';

		case 7:
			return 'G';

		default:
			return 'N';
		}

	}

	/**
	 * This method adds the computed allocated 5 preferences and total
	 * preference of individual student to the ArrayList.
	 * 
	 * @param int[]
	 *            passed after algorithm allocates 5 courses to students.
	 * @return Nothing.
	 */

	public synchronized void addPreferences(int[] allocated) {
		Logger.writeMessage("An entry is added to the Result's data structure.", DebugLevel.NEWENTRY);

		pref1.add(allocated[1]);
		pref2.add(allocated[2]);
		pref3.add(allocated[3]);
		pref4.add(allocated[4]);
		pref5.add(allocated[5]);
		total.add(allocated[6]);

	}

	@Override
	public String toString() {
		return "Results [pref1=" + pref1 + ", pref2=" + pref2 + ", pref3=" + pref3 + ", pref4=" + pref4 + ", pref5="
				+ pref5 + ", total=" + total + ", sum=" + sum + "]";
	}

}