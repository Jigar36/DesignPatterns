package wordCount.TreeForStrings;

import wordCount.visitors.TreeProcessingVisitorI;

public class BSTtree {

	private BSTNode root;
	private int noOfWords = 0;
	private int noOfCharacters = 0;
	private int noOfDistinctWords = 0;

	public BSTtree(BSTNode rootIn) {
		root = rootIn;
	}

	public BSTNode getRoot() {
		return root;
	}

	public void setRoot(BSTNode root) {
		this.root = root;
	}

	public void accept(TreeProcessingVisitorI visitor) {

		visitor.visit(this);

	}

	public void insert(String wordIn) {
		if (root == null) {
			setRoot(new BSTNode());
			root.setFreq(1);
			root.setWord(wordIn);
			root.setCharCount(root.getWord().length());
	//		System.out.println("Word stored at root " + root.getWord());
			return;
		} else {
			insertIntoTree(getRoot(), wordIn);
		}
	}

	public void insertIntoTree(BSTNode root, String word) {
		BSTNode parent = null;

		while (root != null) {
			if (root.getWord().equalsIgnoreCase(word)) {
				root.setFreq(root.getFreq() + 1);
				root.setCharCount(root.getWord().length() + root.getCharCount());
				return;
			} else if (root.getWord().compareToIgnoreCase(word) < 0) {
				parent = root;
				root = root.right;
			} else if (root.getWord().compareToIgnoreCase(word) > 0) {
				parent = root;
				root = root.left;
			} else {
				System.out.println("word misedmatch error...");
			}
		}
		if (parent.getWord().compareToIgnoreCase(word) < 0) {

			parent.right = new BSTNode();
			parent.right.setWord(word);
			parent.right.setFreq(1);
			parent.right.setCharCount(word.length());

			// System.out.println(parent.right.getWord() + "
			// ------------>right");
		} else if (parent.getWord().compareToIgnoreCase(word) > 0) {

			parent.left = new BSTNode();
			parent.left.setWord(word);
			parent.left.setFreq(1);
			parent.left.setCharCount(word.length());

			// System.out.println(parent.left.getWord() + " -->left");

		} else {
			System.out.println("word misedmatch error...");
		}
		return;
	}

	public void traverse() {
		if (root == null) {
			System.out.println("root is null");
			return;
		}
		traverse(root);
	}

	public void traverse(BSTNode root) {
		if (root != null) {
			traverse(root.left);
			noOfWords += root.getFreq();
			//System.out.println(root.getWord() + "-- occurs for --" + root.getFreq() + " --times.");
			noOfCharacters += root.getCharCount();
			noOfDistinctWords++;
			traverse(root.right);
		}
	}

	public int getWordCount() {
		return noOfWords;
	}

	public int getCharCount() {
		return noOfCharacters;
	}

	public int getDistinctWord() {
		return noOfDistinctWords;
	}

}
