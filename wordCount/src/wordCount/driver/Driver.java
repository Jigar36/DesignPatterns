package wordCount.driver;



import wordCount.TreeForStrings.BSTNode;
import wordCount.TreeForStrings.BSTtree;
import wordCount.util.FileProcessor;
import wordCount.visitors.PopulateTreeVisitor;
import wordCount.visitors.TreeProcessingVisitorI;
import wordCount.visitors.WordCountVisitor;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String INPUT_FILE = "dictionary.txt";
		String OUTPUT_FILE = "output.txt";
		int LOOP = 1;
		int i =1;
//		int LOGGER_VALUE = 0;
		
		BSTNode rootNode = null;
		
		FileProcessor file = null;
		
		long startTime = System.currentTimeMillis();
		
		while(i<=LOOP){
			System.out.println("processing");
			file = new FileProcessor(INPUT_FILE,OUTPUT_FILE);
			
			BSTtree bst = new BSTtree(rootNode);
			
			System.out.println("Populating data into tree...");
			TreeProcessingVisitorI populateTreeVisitor = new PopulateTreeVisitor(file);
			bst.accept(populateTreeVisitor);
			
			System.out.println("Getting the counts...");
			TreeProcessingVisitorI wordCountVisitor = new WordCountVisitor(file);
			bst.accept(wordCountVisitor);
			
			i++;
		}
		long finishTime = System.currentTimeMillis();
		long total_time = (finishTime-startTime)/LOOP;
		System.out.println("Total time taken is: "+total_time);
	}

}
