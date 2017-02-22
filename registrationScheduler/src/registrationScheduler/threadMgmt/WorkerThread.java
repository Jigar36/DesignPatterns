package registrationScheduler.threadMgmt;

import java.io.IOException;
import java.util.Arrays;

import registrationScheduler.store.Results;
import registrationScheduler.util.AllocateCourse;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class WorkerThread implements Runnable {

	private FileProcessor fileInput;
	private Results write;
	private AllocateCourse allocateInstance;

	private int[] prefArray = new int[8];

	public WorkerThread(FileProcessor fileInputIn, Results writeIn, AllocateCourse allocateInstanceIn) {
		Logger.writeMessage("WorkerThread Constructor called", DebugLevel.CONSTRUCTOR);
		fileInput = fileInputIn;
		write = writeIn;
		allocateInstance = allocateInstanceIn;
	}

	/**
	 * This is the run method inside the WorkerThread
	 * 
	 * @param Nothing.
	 * @return Nothing.
	 * @exception IOException
	 *                when reading file is not readable.
	 */

	public void run() {
		Logger.writeMessage("Run method of WorkerThread called.", DebugLevel.THREADRUNMETHOD);
		String readLine;
		String[] data;
		int[] allocated = new int[7];
		int i = 1;
		try {
			while ((readLine = fileInput.readLineFromFile()) != null) {
				data = readLine.split("\\s+");

				prefArray[0] = i;
				prefArray[1] = Integer.parseInt(data[1]);
				prefArray[2] = Integer.parseInt(data[2]);
				prefArray[3] = Integer.parseInt(data[3]);
				prefArray[4] = Integer.parseInt(data[4]);
				prefArray[5] = Integer.parseInt(data[5]);
				prefArray[6] = Integer.parseInt(data[6]);
				prefArray[7] = Integer.parseInt(data[7]);

				allocated = allocateInstance.allocate(prefArray);
				write.addPreferences(allocated);

			}
		} catch (IOException e) {
			System.err.println("Error while reading a file.");
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		return "WorkerThread [fileInput=" + fileInput + ", write=" + write + ", allocateInstance=" + allocateInstance
				+ ", prefArray=" + Arrays.toString(prefArray) + "]";
	}
}
