package registrationScheduler.util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import registrationScheduler.util.Logger.DebugLevel;

public class FileProcessor {

	private String fileName;
	private BufferedReader bufferedReader;

	public FileProcessor(String fileNameIn) {
		Logger.writeMessage("In FileProcessor Constructor", DebugLevel.CONSTRUCTOR);
		fileName = fileNameIn;
		try {
			this.bufferedReader = new BufferedReader(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			System.out.println("Exception:\"" + fileName + "\" does not exist");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileNameIn) {
		fileName = fileNameIn;

	}

	/**
	 * This method concurrently reads line from the input file
	 * 
	 * @param Nothing.
	 * @return Srting readLine.
	 * @exception IOException.
	 */

	public synchronized String readLineFromFile() throws IOException {
		String readLine = null;
		try {

			if ((readLine = bufferedReader.readLine()) != null) {
				return readLine;
			}
		} catch (IOException ex) {
			ex.printStackTrace();
			System.exit(1);
		}

		return readLine;
	}

	public void closeBufferedReader() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println("Error while closing file");
			e.printStackTrace();
		}
	}
}
