package wordCount.visitors;

import java.io.IOException;

import wordCount.TreeForStrings.BSTtree;
import wordCount.util.FileProcessor;

public class PopulateTreeVisitor implements TreeProcessingVisitorI {

	private FileProcessor file;

	public PopulateTreeVisitor(FileProcessor fileIn) {
		file = fileIn;
	}

	@Override
	public void visit(BSTtree bst) {

		String in = null;
		try {
			while ((in = file.readLineFromFile()) != null) {
				String[] readLine = null;
				readLine = in.split("\\W+");
				for (int i = 0; i < readLine.length; i++)
					if (readLine[i].length() != 0 && readLine[i] != null) {
						bst.insert(readLine[i]);

					}
			}
		} catch (IOException e) {
			System.err.println("Error in file reading.");
			e.printStackTrace();
			System.exit(1);
		} finally {
			System.out.println("File read Complete...");
		}

	}

}
