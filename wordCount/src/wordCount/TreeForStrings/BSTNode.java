package wordCount.TreeForStrings;

public class BSTNode {
	private String word;
	private int freq;
	private int charCount;

	public BSTNode left;
	public BSTNode right;
	
	public BSTNode() {
			
			left = null;
			right = null;
	}
	
	
	public String getWord() {
		return word;
	}
	public void setWord(String word) {
		this.word = word;
	}
	
	public int getFreq() {
		return freq;
	}
	public void setFreq(int freq) {
		this.freq = freq;
	}
	public int getCharCount() {
		return charCount;
	}
	public void setCharCount(int charCount) {
		this.charCount = charCount;
	}
	
	
}
