package interpretator;

import iterator.IteratorBFS;
import structure.Structure.Node;
import structure.Tree;
import java.util.List;

public class Interpretator {
    Tree tree = new Tree();

    public void interpretator(String string){
        if (string.startsWith("return children")) {
            returnChildren(string.substring(string.indexOf('<'), string.indexOf('>')),
                    string.substring(string.indexOf('>') + 1));
        }
        else {
            if (string.startsWith("delete")) {
                delete(string.substring(string.indexOf('<'), string.indexOf('>')));
            }
        }
    }

    private List<Node> returnChildren(String type, String string){
        IteratorBFS iteratorBFS = new IteratorBFS(tree);
        Node node = new Node();
        while ((!iteratorBFS.next().getName().equals(string))&&(!iteratorBFS.next().getType().equals(type))){
            node = iteratorBFS.next();
        }
        return node.getChildren();
    }

    private boolean delete(String string){
        IteratorBFS iteratorBFS = new IteratorBFS(tree);
        String[] words = string.split("\\s");
        String nodeName = words[words.length-1];
        Node node = null;
        while (!iteratorBFS.next().getName().equals(nodeName)){
            node = iteratorBFS.next();
        }
        if (node.getName().equals(nodeName)){
            node.getParent().getChildren().remove(node);
            return true;
        } else return false;
    }
}
