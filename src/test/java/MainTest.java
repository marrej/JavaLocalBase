import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    private CodeWorker codeWorker;

    @BeforeEach
    public void setUp() throws Exception{
        codeWorker = new CodeWorker();
    }

    @Test
    void testMethod() {
        assertEquals(codeWorker.testMethod(), "method");
    }

    @Test
    void rootAsLCA() {
        var root = new TreeNode(1);
        var secondDown = new TreeNode(2);
        root.left = secondDown;
        var p = root;
        var q = secondDown;

        assertEquals(root, codeWorker.lowestCommonAncestor(root, p, q));
    }


    @Test
    void rootAsLCA2() {
        var root = new TreeNode(3);
        var secondDownLeft = new TreeNode(2);
        var secondDownRight = new TreeNode(1);
        root.left = secondDownLeft;
        root.right = secondDownRight;
        var p = secondDownLeft;
        var q = secondDownRight;

        assertEquals(root, codeWorker.lowestCommonAncestor(root, p, q));
    }

    @Test
    void deepDownLeftAndRightCommonRoot() {
        var root = new TreeNode(3);
        var secondDownLeft = new TreeNode(2);
        var tDownLeft = new TreeNode(4);
        var fDownLeft = new TreeNode(5);
        var ffDownLeft = new TreeNode(6);
        var secondDownRight = new TreeNode(1);
        root.left = secondDownLeft;
        root.right = secondDownRight;

        secondDownLeft.left = tDownLeft;
        tDownLeft.right = fDownLeft;
        fDownLeft.left = ffDownLeft;
        var p = ffDownLeft;
        var q = secondDownRight;

        assertEquals(root, codeWorker.lowestCommonAncestor(root, p, q));
    }

    @Test
    void tDownleftCommon() {
        var root = new TreeNode(3);
        var secondDownLeft = new TreeNode(2);
        var tDownLeft = new TreeNode(4);
        var fDownLeft = new TreeNode(5);
        var ffDownLeft = new TreeNode(6);
        var secondDownRight = new TreeNode(1);
        root.left = secondDownLeft;
        root.right = secondDownRight;

        secondDownLeft.left = tDownLeft;
        tDownLeft.right = fDownLeft;
        fDownLeft.left = ffDownLeft;
        var p = ffDownLeft;
        var q = tDownLeft;

        assertEquals(tDownLeft, codeWorker.lowestCommonAncestor(root, p, q));
    }
}