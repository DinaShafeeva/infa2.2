package facade;

import facade.FacadeJSon;
import facade.FacadeXML;
import structure.Structure.Node;

import java.util.List;

public class FacadeClass {

    FacadeXML facadeXML = new FacadeXML();
    FacadeJSon facadeJSon = new FacadeJSon();
    private static FacadeClass facadeClass = new FacadeClass();

    private FacadeClass() {
    }

    public static FacadeClass getInstance(){
        if (facadeClass == null){
            return new FacadeClass();
        } else return  facadeClass;
    }

    public void writeTree(Type type, Node node) {
        if (type == Type.XML){
            facadeXML.writeTree(node);
        } else {
            if (type == Type.JSON){
                facadeJSon.writeTree(node);
            }
        }
    }

    public List<Node> readTree(Type type, String fileName) {
        if (type == Type.XML){
            return facadeXML.readTree("xml.txt");
        } else {
            if (type == Type.JSON){
                return facadeJSon.readTree("json.txt");
            }
        }
        return null;
    }

    public enum Type{
        XML,
        JSON
    }
}
