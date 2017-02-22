package registrationScheduler.driver;

import registrationScheduler.threadMgmt.CreateWorkers;
import registrationScheduler.util.AllocateCourse;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.store.Results;
import registrationScheduler.util.Logger;

/**
 * The main Driver method which calls methods to create threads and prints
 * allocated course preferences on to screen and to file..
 * 
 * @param args.
 * @return Nothing.
 * @exception NumberFormatException
 *                when invalid argument entered.
 */

public class Driver {

	public Driver() {

	}

	public static void main(String[] args) {

		String INPUT_FILE = null;
		String OUTPUT_FILE = null;
		FileProcessor file = null;
		int LOGGER_VALUE = 0;
		int THREADS_TOT = 0;

		try {
			if (args.length != 4) {
				System.err.println("Invalid number of argumnets passed, Please Try Again.");
				System.exit(1);
			}

			INPUT_FILE = args[0];
			OUTPUT_FILE = args[1];
			THREADS_TOT = Integer.parseInt(args[2]);
			LOGGER_VALUE = Integer.parseInt(args[3]);

			if (!(THREADS_TOT >= 1 && THREADS_TOT <= 3)) {
				System.err.println("Invalid number of threads.");
				System.exit(1);
			} else if (!(LOGGER_VALUE >= 0 && LOGGER_VALUE <= 4)) {
				System.err.println("Invalid number of Logger value.");
				System.exit(1);
			}

			Logger.setDebugValue(LOGGER_VALUE);

			file = new FileProcessor(INPUT_FILE);
			AllocateCourse allocateInstance = new AllocateCourse();
			Results writeScreen = new Results();

			CreateWorkers createWorkers = new CreateWorkers(file, writeScreen, allocateInstance);
			createWorkers.startWorkers(THREADS_TOT);

			writeScreen.writeToScreen();
			writeScreen.writeSchedulesToFile(OUTPUT_FILE);

		} catch (NumberFormatException e) {
			System.err.println("Error in reading the file.");
			e.printStackTrace();
			System.exit(1);
		} finally {
			file.closeBufferedReader();
		}
	}
}