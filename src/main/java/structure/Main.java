package structure;

import facade.Facade;
import facade.FacadeClass;
import iterator.IteratorDFS;
import iterator.IteratorPriority;
import structure.Structure.Node;
import structure.Tree;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Tree tree = new Tree();
        tree.setRoot(Structure.Node.builder()
                .name("Russia")
                .children(new ArrayList<Node>())
                .parent(null)
                .type(Structure.Type.COUNTRY)
                .priority(1)
                .build());

        Structure.Node nodeNearVolga = Structure.Node.builder()
                .name("NearVolga")
                .children(new ArrayList<>())
                .parent(tree.getRoot())
                .type(Structure.Type.REGION)
                .priority(1)
                .build();

        tree.getRoot().addChildren(nodeNearVolga);

        Node nodeNearNeVolga = Structure.Node.builder()
                .name("NearNeVolga")
                .children(new ArrayList<>())
                .parent(tree.getRoot())
                .type(Structure.Type.REGION)
                .priority(2)
                .build();

        tree.getRoot().addChildren(nodeNearNeVolga);

        Node nodeRT = Structure.Node.builder()
                .name("Tatarstan")
                .children(new ArrayList<>())
                .parent(nodeNearVolga)
                .type(Structure.Type.DISTRICT)
                .priority(1)
                .build();

        nodeNearVolga.addChildren(nodeRT);

        Node nodeRB = Structure.Node.builder()
                .name("Bashkiria")
                .children(new ArrayList<>())
                .parent(nodeNearVolga)
                .type(Structure.Type.DISTRICT)
                .priority(1)
                .build();

        nodeNearNeVolga.addChildren(nodeRB);


        IteratorDFS iteratorDFS = new IteratorDFS(tree);
//        while (iteratorDFS.hasNext()) {
//            System.out.println(iteratorDFS.next().getName() + ",");
//        }
        FacadeClass facadeClass =  FacadeClass.getInstance();
        facadeClass.writeTree(FacadeClass.Type.XML, nodeNearNeVolga);
//        for (Node n : facadeClass.readTree(FacadeClass.Type.XML, "json.txt")){
//            System.out.println(n.getName() + ",");
//        }
    }
}
