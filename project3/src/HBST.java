class HBST<Key, Value> {
	private class ValueNode {
		Key key;
		Value value;
		ValueNode next;

		public ValueNode(Key key, Value value, ValueNode next) {
			this.key = key;
			this.value = value;
			this.next = next;
		}
	}

	private class TreeNode {
		int key;
		ValueNode value;
		TreeNode left, right;

		public TreeNode(int key, ValueNode value, TreeNode left, TreeNode right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	public HBST() {

	}

	public Value get(Key key) {

	}

	private int hash(Key key) {

	}

	public int height() {

	}

	public void put(Key key, Value value) {

	}
}
