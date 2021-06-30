
public class Main {
    public static void main(String[] args)  {
        CodeWorker code = new CodeWorker();
    }


}

class CodeWorker {
    public String testMethod() {
        return "method";
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        var updatedPQ = this.findThePQ(root, p, q);
        return updatedPQ.parent;
    }

    public PQParent findThePQ(TreeNode actualRoot, TreeNode p, TreeNode q) {
        var pq = new PQParent();

        if (actualRoot.left != null) {
            var updatedPQ = this.findThePQ(actualRoot.left, p, q);
            if (updatedPQ.isP || updatedPQ.isQ) {
                pq.isP = updatedPQ.isP ? true : pq.isP;
                pq.isQ = updatedPQ.isQ ? true : pq.isQ;
                pq.parent = updatedPQ.parent;
                pq.parentLocked = updatedPQ.parentLocked;
            }
        }


        if (actualRoot.right != null) {
            var updatedPQ =this.findThePQ(actualRoot.right, p, q);
            if (updatedPQ.isP || updatedPQ.isQ) {
                pq.isP = updatedPQ.isP ? true : pq.isP;
                pq.isQ = updatedPQ.isQ ? true : pq.isQ;
                pq.parent = updatedPQ.parent;
                pq.parentLocked = updatedPQ.parentLocked;
            }
        }


        // We might need to check if it is that actual node by checking the left and right if they match
        if (actualRoot.val == p.val) {
            pq.isP = true;
            pq.parent = actualRoot;
        }

        if (actualRoot.val == q.val) {
            pq.isQ = true;
            pq.parent = actualRoot;
        }

        if (pq.isQ && pq.isP && !pq.parentLocked) {
            pq.parent = actualRoot;
            pq.parentLocked = true;
        }

        return pq;
    }

}

class PQParent {
    boolean isP = false;
    boolean isQ = false;
    TreeNode parent = null;
    boolean parentLocked = false;

    PQParent() {

    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}