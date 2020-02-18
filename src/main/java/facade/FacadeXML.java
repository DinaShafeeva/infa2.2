package facade;

import com.fasterxml.jackson.databind.ObjectMapper;
import structure.Structure.Node;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class FacadeXML implements Facade {
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void writeTree(Node node) {
        try(FileWriter writer = new FileWriter("xml.xml", false))
        {
            JAXBContext jaxbContext = JAXBContext.newInstance(Node.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            jaxbMarshaller.marshal(node, writer);

        }
        catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public List<Node> readTree(String fileName) {
        File xmlFile = new File(fileName);
        List<Node> list = new ArrayList<>();

        JAXBContext jaxbContext;
        try
        {
            jaxbContext = JAXBContext.newInstance(Node.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Node node = (Node) jaxbUnmarshaller.unmarshal(xmlFile);
            list.add(node);
        }
        catch (JAXBException e)
        {
            e.printStackTrace();
        }
        return list;
    }
}
