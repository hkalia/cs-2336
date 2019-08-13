class bst {

    Node root;

    public bst() {
        this.root = null;
    }

    public void insert(String keyword, FileData fd) {
        Record recordToAdd = new Record(fd.id, fd.title, fd.author, null);
        //TODO Write a recursive insertion that adds recordToAdd to the list of records for the node associated
        //with keyword. If there is no node, this code should add the node.
        this.root = insertRecursive(this.root, keyword, recordToAdd);
    }

    private Node insertRecursive(Node root, String keyword, Record recordToAdd) {
        if (root == null) {
            root = new Node(keyword);
            root.update(recordToAdd);
            return root;
        }
        if (0 < root.keyword.compareTo(keyword)) root.r = insertRecursive(root.r, keyword, recordToAdd);
        else if (root.keyword.compareTo(keyword) < 0) root.l = insertRecursive(root.l, keyword, recordToAdd);
        return root;
    }

    public boolean contains(String keyword) {
        //TODO Write a recursive function which returns true if a particular keyword exists in the bst
        return find(this.root, keyword) != null;
    }

    private Node find(Node root, String keyword) {
        if (root == null) return null;
        // found
        if (root.keyword.equals(keyword)) return root;
        if (0 < root.keyword.compareTo(keyword)) return find(root.r, keyword);
        return find(root.l, keyword);
    }

    public Record get_records(String keyword) {
        //TODO Returns the first record for a particular keyword. This record will link to other records
        //If the keyword is not in the bst, it should return null.
        Node found = find(this.root, keyword);
        if (found == null) return null;
        return found.record;
    }

    public void delete(String keyword) {
        //TODO Write a recursive function which removes the Node with keyword from the binary search tree.
        //You may not use lazy deletion and if the keyword is not in the bst, the function should do nothing.
        this.root = deleteRecursive(this.root, keyword);
    }

    private Node deleteRecursive(Node root, String keyword) {
        if (root == null) return null;
        if (0 < root.keyword.compareTo(keyword)) root.r = deleteRecursive(root.r, keyword);
        else if (root.keyword.compareTo(keyword) < 0) root.l = deleteRecursive(root.l, keyword);
        else if (root.keyword.equals(keyword)) {
            // leaf node or node with only one child
            if (root.r == null) return root.l;
            else if (root.l == null) return root.r;
                // two children
            else {
                // get largest (right most) value in left subtree
                Node current = root.l;
                Node max = current;
                while (current.r != null) {
                    max = current.r;
                    current = current.r;
                }
                // replace current with right most value
                root.keyword = max.keyword;
                root.record = max.record;
                root.size = max.size;
                // delete right most value
                root.l = deleteRecursive(root.l, max.keyword);
            }
        }
        return root;
    }

    public void print() {
        print(root);
    }

    private void print(Node t) {
        if (t != null) {
            print(t.l);
            System.out.println(t.keyword);
            Record r = t.record;
            while (r != null) {
                System.out.printf("\t%s\n", r.title);
                r = r.next;
            }
            print(t.r);
        }
    }

    private class Node {

        // These attributes of the Node class will not be sufficient for those attempting the AVL extra credit.
        // You are free to add extra attributes as you see fit, but do not remove attributes given as it will mess with help code.
        String keyword;
        Record record;
        int size;
        Node l;
        Node r;

        private Node(String k) {
            // TODO Instantialize a new Node with keyword k.
            this.keyword = k.trim();
        }

        private void update(Record r) {
            //TODO Adds the Record r to the linked list of records. You do not have to check if the record is already in the list.
            //HINT: Add the Record r to the front of your linked list.
            if (this.record == null || this.size == 0) {
                this.record = r;
                this.size++;
                return;
            }
            Record current = this.record;
            r.next = this.record;
            this.record = r;
            this.size++;
        }
    }
}
