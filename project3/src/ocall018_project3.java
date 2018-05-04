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
		Key key;
		ValueNode value;
		TreeNode left, right;

		public TreeNode(Key key, ValueNode value, TreeNode left, TreeNode right) {
			this.key = key;
			this.value = value;
			this.left = left;
			this.right = right;
		}
	}

	private TreeNode head;

	public HBST() {
		head = new TreeNode(null, new ValueNode(null, null, null), null, null);
	}

	public Value get(Key key) {
		TreeNode subtree = head;
		int hashedKey = hash(key);
		while (subtree != null) {
			int test = hashedKey - hash(subtree.key);
			if (test < 0) {
				subtree = subtree.left;
			} else if (test > 0) {
				subtree = subtree.right;
			} else {
				ValueNode temp = subtree.value;
				while (temp != null) {
					if (hash(temp.key) == hashedKey) {
						return temp.value;
					} else {
						temp = temp.next;
					}
				}
			}
		}
		throw new IllegalArgumentException("No such key");
	}

	private int hash(Key key) {
		if (key != null) {
			return Math.abs(key.hashCode());
		} else {
			return 0;
		}
	}

	public int height() {
		return heighting(head.right);
	}

	public void put(Key key, Value value) {
		TreeNode subtree = head;
		int hashedKey = hash(key);
		while (true) {
			int test = hashedKey - hash(subtree.key);
			if (test < 0) {
				if (subtree.left == null) {
					subtree.left = new TreeNode(key, new ValueNode(key, value, null), null, null);
					return;
				} else {
					subtree = subtree.left;
				}
			} else if (test > 0) {
				if (subtree.right == null) {
					subtree.right = new TreeNode(key, new ValueNode(key, value, null), null, null);
					return;
				} else {
					subtree = subtree.right;
				}
			} else {
				ValueNode temp = subtree.value;
				while (true) {
					if (temp.key != key) {
						if (temp.next == null) {
							temp.next = new ValueNode(key, value, null);
							return;
						} else {
							temp = temp.next;
						}
					} else {
						temp.value = value;
						return;
					}
				}
			}
		}
	}

	private int heighting(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			int left = heighting(root.left);
			int right = heighting(root.right);
			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}
}

class HBSTifier {
	private final static String[] keys =
			{"abstract", "assert", "boolean", "break",
					"byte", "case", "catch", "char",
					"class", "const", "continue", "default",
					"do", "double", "else", "extends",
					"false", "final", "finally", "float",
					"for", "goto", "if", "implements",
					"import", "instanceof", "int", "interface",
					"long", "native", "new", null,
					"package", "private", "protected", "public",
					"return", "short", "static", "super",
					"switch", "synchronized", "this", "throw",
					"throws", "transient", "true", "try",
					"var", "void", "volatile", "while",
					"abstract", "null", "15", "csci-1913",
					"Professor", "James", "Moen", "if",
					"Moen", "void", "null", null};

	public static void main(String[] args) {
		HBST<String, Integer> hbst = new HBST<String, Integer>();

		for (int index = 0; index < keys.length; index += 1) {
			hbst.put(keys[index], index);
		}

		System.out.println(hbst.height());
		for (int index = 0; index < keys.length; index += 1) {
			System.out.format("%02d %s", hbst.get(keys[index]), keys[index]);
			System.out.println();
		}
	}
}

/*
Test output using the String array declared above:
17
52 abstract
01 assert
02 boolean
03 break
04 byte
05 case
06 catch
07 char
08 class
09 const
10 continue
11 default
12 do
13 double
14 else
15 extends
16 false
17 final
18 finally
19 float
20 for
21 goto
59 if
23 implements
24 import
25 instanceof
26 int
27 interface
28 long
29 native
30 new
63 null
32 package
33 private
34 protected
35 public
36 return
37 short
38 static
39 super
40 switch
41 synchronized
42 this
43 throw
44 throws
45 transient
46 true
47 try
48 var
61 void
50 volatile
51 while
52 abstract
62 null
54 15
55 csci-1913
56 Professor
57 James
60 Moen
59 if
60 Moen
61 void
62 null
63 null
*/
