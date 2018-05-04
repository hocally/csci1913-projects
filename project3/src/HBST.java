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
        head = new TreeNode(null, null, null, null);
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
                if (subtree.value == null) {
                    subtree.value = new ValueNode(key, value, null);
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
