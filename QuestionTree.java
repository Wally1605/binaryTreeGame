
public class QuestionTree {
    QuestionNode root;
    QuestionTree(String Question){
        root = new QuestionNode(Question);
    }
    public void add(QuestionNode parentNode, QuestionNode childNode, String direction)
    {
        if (direction.equals("left")) {
            parentNode.setLeft(childNode);
        }
        else {
            parentNode.setRight(childNode);
        }
    }



}
