package registrationScheduler.threadMgmt;

import registrationScheduler.store.StdoutDisplayInterface;
import registrationScheduler.store.Results;
import registrationScheduler.util.AllocateCourse;
import registrationScheduler.util.FileProcessor;
import registrationScheduler.util.Logger;
import registrationScheduler.util.Logger.DebugLevel;

public class CreateWorkers {

	private FileProcessor fileInput;
	private Results write;
	private AllocateCourse allocateInstance;

	public CreateWorkers(FileProcessor fileInputIn, Results writeIn, AllocateCourse allocateInstanceIn) {
		Logger.writeMessage("In CreateWorkers Class Constructor", DebugLevel.CONSTRUCTOR);
		fileInput = fileInputIn;
		write = writeIn;
		allocateInstance = allocateInstanceIn;
	}

	/**
	 * This method creates WorkerThread/s.
	 * 
	 * @param int
	 *            THREADS_TOT is the number of threads.
	 * @return Nothing.
	 * @exception InterruptedException
	 *                if thread interrupted.
	 */

	public void startWorkers(int THREADS_TOT) {

		Thread workerThread[] = new Thread[THREADS_TOT];

		for (int i = 0; i < THREADS_TOT; i++) {

			workerThread[i] = new Thread(new WorkerThread(fileInput, write, allocateInstance));
			workerThread[i].start();
			workerThread[i].setName("Thread_" + i);
		}

		for (int i = 0; i < THREADS_TOT; i++) {
			try {

				workerThread[i].join();

			} catch (InterruptedException e) {
				System.err.println("Thread is Interrupted");
				e.printStackTrace();
			}
		}
	}

	public FileProcessor getFileInput() {
		return fileInput;
	}

	public void setFileInput(FileProcessor fileInputIn) {
		fileInput = fileInputIn;
	}

	public StdoutDisplayInterface getWrite() {
		return write;
	}

	public void setWrite(Results writeIn) {
		write = writeIn;
	}

	public AllocateCourse getAllocateInstance() {
		return allocateInstance;
	}

	public void setAllocateInstance(AllocateCourse allocateInstanceIn) {
		allocateInstance = allocateInstanceIn;
	}
}
