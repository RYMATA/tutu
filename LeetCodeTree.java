package Sprint4_review;


public class B {
    static class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
            right = null;
            left = null;
        }
    }


    public static int res = Integer.MIN_VALUE;
    public static String treeSolution(Node head){

        findMaxPath(head,res);
        return String.valueOf(res);
    }

    public static int findMaxPath(Node node,  int res){

        if(node == null){
            return 0;
        }

        int l = findMaxPath(node.left, res);
        int r = findMaxPath(node.right, res);

        int maxCurr = Math.max(Math.max(l,r) + node.value, node.value);


        int pathSum = Math.max(maxCurr, l + r + node.value);

        res = Math.max(pathSum, res);


        return maxCurr;
    }

}
