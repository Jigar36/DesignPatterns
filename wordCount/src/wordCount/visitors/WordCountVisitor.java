package wordCount.visitors;

import wordCount.TreeForStrings.BSTtree;
import wordCount.util.FileProcessor;

public class WordCountVisitor implements TreeProcessingVisitorI {

	private FileProcessor file;
	private int wordCount;
	private int charCount;
	private int DistinctWordsCount;
	
	
	public WordCountVisitor(FileProcessor fileIn) {
		file = fileIn;
	}



	@Override
	public void visit(BSTtree bst) {
		// TODO Auto-generated method stub
		bst.traverse();
		wordCount = bst.getWordCount();
		charCount = bst.getCharCount();
		DistinctWordsCount = bst.getDistinctWord();
		System.out.println("word count is "+wordCount);
		System.out.println("char count is "+charCount);
		System.out.println("distinct words count is "+DistinctWordsCount);

	}

}
