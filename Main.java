import java.util.Scanner;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //Modified yesTo method to return string
    static public String yesTo() {

        Scanner sc = new Scanner(System.in);

        String response = sc.nextLine().trim().toLowerCase();

        while (!response.equals("yes") && !response.equals("no")) {

            System.out.println("Please answer yes or no.");

            response = sc.nextLine().trim().toLowerCase();

        }

        return response;

    }
    //Asks user if they want to play again
    static public String playAgain(){
        String answer;
        System.out.println("Play again? yes/no");
        answer = yesTo();
        return answer;
    }

    public static void main(String[] args) {
        String answer = "";
        Scanner sc = new Scanner(System.in);

        //Creating root
        QuestionTree game = new QuestionTree("Is it an animal?");
        QuestionNode current = game.root;

        //Creating all initial nodes
        QuestionNode n1 = new QuestionNode("Can it fly?");
        QuestionNode n2 = new QuestionNode("Does it have wheels?");
        QuestionNode n3 = new QuestionNode("bird");
        QuestionNode n4 = new QuestionNode("Does it have a tail?");
        QuestionNode n5 = new QuestionNode("Spider");
        QuestionNode n6 = new QuestionNode("Cat");
        QuestionNode n7 = new QuestionNode("Bicycle");
        QuestionNode n8 = new QuestionNode("Is it nice?");
        QuestionNode n9 = new QuestionNode("TA");
        QuestionNode n10 = new QuestionNode("Professor");

        //Adding all nodes to tree:
        game.add(game.root, n1, "right");
        game.add(game.root, n2, "left");

        game.add(n1, n3, "right");
        game.add(n1, n4, "left");

        game.add(n4, n5, "left");
        game.add(n4, n6, "right");

        game.add(n2, n7, "right");
        game.add(n2, n8, "left");

        game.add(n8, n9, "right");
        game.add(n8, n10, "left");
        //Game continues if user doesn't input "n"
        while (!(answer.equals("n"))){
            //Prints current node the game is on
            System.out.println(current.getKey());
            answer = yesTo();
            //If user inputs "yes" it traverses right of the tree.
            if (answer.equals("yes")) {
                current = current.getRight();
                //Checks if current node is a leaf by seeing if it has no children.
                if(current.getLeft() == null && current.getRight() == null){
                    System.out.println("Is it perhaps a "+current.getKey());
                    answer = yesTo();
                    //If guess is correct nothing is done, game restarts.
                    if(answer.equals("yes")){
                        System.out.println("Great! I got it right!");
                        current = game.root;
                        answer = playAgain();
                    }else if(answer.equals("no")){
                        //If answer is no, creates a new node with the question.
                        System.out.println("What was the name of your object?");
                        answer = sc.nextLine();
                        QuestionNode answerNode = new QuestionNode(answer);
                        System.out.println("What is a yes/no question to help guess it?");
                        answer = sc.nextLine();
                        QuestionNode questionNode = new QuestionNode(answer);
                        System.out.println("What is the answer to it? (yes/no)");
                        answer = yesTo();
                        //Creates question with the answernode to the right
                        if(answer.equals("yes")){
                            QuestionNode temp = new QuestionNode(current.getKey());
                            current.setKey(questionNode.getKey());

                            game.add(current, temp, "left");
                            game.add(current, answerNode, "right");
                            current = game.root;
                            answer = playAgain();
                        }else if(answer.equals("no")){
                            //creates question wit the answer node to the left
                            QuestionNode temp = new QuestionNode(current.getKey());
                            current.setKey(questionNode.getKey());
                            game.add(current, answerNode, "left");
                            game.add(current, temp, "right");
                            current = game.root;
                            answer = playAgain();
                        }
                    }
                }
            }



            //These if statements do the exact same things as above except it is on the left side of the tree.
            else if (answer.equals("no")) {

                current = current.getLeft();

                if(current.getLeft() == null && current.getRight() == null){
                    System.out.println("Is it perhaps a "+current.getKey());
                    answer = yesTo();
                    if(answer.equals("yes")){
                        System.out.println("Great! I got it right!");
                        current = game.root;
                        answer = playAgain();
                    }else if(answer.equals("no")){
                        System.out.println("What was the name of your object?");
                        answer = sc.nextLine();
                        QuestionNode answerNode = new QuestionNode(answer);
                        System.out.println("What is a yes/no question to help guess it?");
                        answer = sc.nextLine();
                        QuestionNode questionNode = new QuestionNode(answer);
                        System.out.println("What is the answer to it? (yes/no)");
                        answer = yesTo();
                        if(answer.equals("yes")){
                            QuestionNode temp = new QuestionNode(current.getKey());
                            current.setKey(questionNode.getKey());

                            game.add(current, temp, "left");
                            game.add(current, answerNode, "right");
                            current = game.root;
                            answer = playAgain();
                        }else if(answer.equals("no")){
                            QuestionNode temp = new QuestionNode(current.getKey());
                            current.setKey(questionNode.getKey());
                            game.add(current, answerNode, "left");
                            game.add(current, temp, "right");
                            current = game.root;
                            answer = playAgain();
                        }
                    }
                }
            }


        }
    }
}
