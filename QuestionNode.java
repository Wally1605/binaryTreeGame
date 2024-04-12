public class QuestionNode{

    String Question;
    QuestionNode left;
    QuestionNode right;

    QuestionNode (String Question) {
        this.Question = Question;
        right = null;
        left = null;
        //leaves have null left and right nodes
    }

    public void setKey(String Question) {
        this.Question = Question;
    }

    public String getKey() {
        return Question;
    }

    public void setLeft(QuestionNode left) {
        this.left = left;
    }

    public QuestionNode getLeft() {
        return left;
    }

    public void setRight(QuestionNode right ) {
        this.right = right;
    }

    public QuestionNode getRight() {
        return right;
    }
}
