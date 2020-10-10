package Algorithm.tree;

//BST 구현
public class BSTreeImplement {
    public static void main(String[] args) {

        Node head = new Node(5);
        BinarySearchTree bst = new BinarySearchTree(head);

        bst.insert(2);
        bst.insert(3);
        bst.insert(4);
        bst.insert(6);
        bst.insert(7);
        bst.insert(8);
        bst.insert(9);
        bst.insert(10);

        System.out.println("BST Tree : " + bst.searchBST(10));
    }

    static class Node {
        int N;
        Node left;
        Node right;

        Node() {
            this.left = null;
            this.right = null;
        }

        Node(int n)  {
            this.N = n;
            this.left = null;
            this.right = null;
        }
    }

    //BST
    static class BinarySearchTree {
        private Node root;

        public BinarySearchTree(Node head) {
            this.root = head;
        }

        //노드 삽입
        public void insert(int value) {
            Node root = this.root;
            Node newNode = new Node(value);

            while (true) {
                if(root.N < value) {
                    if(root.right == null) {
                        root.right = newNode;
                        break;
                    }
                    else root = root.right;
                }else {
                    if(root.left == null) {
                        root.left = newNode;
                        break;
                    }else root = root.left;
                }
            }
        }

        //노드 탐색
        public boolean searchBST(int value) {
            Node p = root;
            while (p != null) {
                if(p.N == value) return true;
                else if(p.N < value) p = p.right;
                else p = p.left;
            }

            return false;
        }

        //노드 삭제

        //preOrder

        //inOrder

        //postOrder


    }
}
