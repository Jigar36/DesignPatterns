package wordCount.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {

	private String inFileName;
	private String outFileName;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;

	public FileProcessor(String inputFileIn, String outputFileIn) {
		inFileName = inputFileIn;
		outFileName = outputFileIn;
		try {
			this.bufferedReader = new BufferedReader(new FileReader(inFileName));
			this.bufferedWriter = new BufferedWriter(new FileWriter(outFileName));
		} catch (FileNotFoundException e) {
			System.out.println("Exception:\"" + inFileName + "\" does not exist");
			e.printStackTrace();
			System.exit(1);
		} catch (IOException e) {
			System.err.println("Error in file operation.");
			e.printStackTrace();
			System.exit(1);
		} finally {

		}
	}

	public String readLineFromFile() throws IOException {
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

	public void writeLineToFile(String write) throws IOException {
		bufferedWriter.write(write);
		bufferedWriter.newLine();
	}

	public void closeBufferedReader() {
		try {
			bufferedReader.close();
		} catch (IOException e) {
			System.err.println("Error while closing file");
			e.printStackTrace();
		}
	}

	public void closeBufferedWriter() {
		try {
			bufferedWriter.close();
		} catch (IOException e) {
			System.err.println("Error while closing file");
			e.printStackTrace();
		}
	}

}
