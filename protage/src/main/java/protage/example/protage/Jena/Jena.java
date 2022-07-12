package protage.example.protage.Jena;

import org.apache.jena.ontology.OntDocumentManager;
import org.apache.jena.ontology.OntModel;
import org.apache.jena.ontology.OntModelSpec;
import org.apache.jena.query.*;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.shared.JenaException;
import org.apache.jena.util.FileManager;

import java.io.InputStream;
import java.util.ArrayList;


public class Jena {
    public static ArrayList<String> execQuery(String queryString) {

        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, null);
        try {
            InputStream in = FileManager.get().open("../instance.owl");
            try {
                OntDocumentManager dm = ontoModel.getDocumentManager();
                dm.addAltEntry( "http://www.semanticweb.org/IZ/2022/Tim12/Klase", "file:../klase.owl" );
                ontoModel.read("http://www.semanticweb.org/IZ/2022/Tim12/Klase", null, "TTL");
                ontoModel.read(in, null, "TTL");
                Query query = QueryFactory.create(queryString);
                QueryExecution quer = QueryExecutionFactory.create(query, ontoModel);
                ResultSet results = quer.execSelect();
                ArrayList<String> list = new ArrayList<String>();
                while (results.hasNext()) {
                    QuerySolution solution = results.nextSolution();
                    list.add(solution.get("x").toString().split("#")[1]);
                }
                return list;

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JenaException je) {
            System.err.println("ERROR" + je.getMessage());
            je.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static String execQuery2(String queryString, String what) {

        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, null);
        try {
            InputStream in = FileManager.get().open("../instance.owl");
            try {
                OntDocumentManager dm = ontoModel.getDocumentManager();
                dm.addAltEntry( "http://www.semanticweb.org/IZ/2022/Tim12/Klase", "file:../klase.owl" );
                ontoModel.read("http://www.semanticweb.org/IZ/2022/Tim12/Klase", null, "TTL");
                ontoModel.read(in, null, "TTL");
                Query query = QueryFactory.create(queryString);
                QueryExecution quer = QueryExecutionFactory.create(query, ontoModel);
                ResultSet results = quer.execSelect();
                ArrayList<String> list = new ArrayList<String>();
                while (results.hasNext()) {
                    QuerySolution solution = results.nextSolution();
                    list.add(solution.get(what).toString().split("\\^")[0]);
                }
                return list.get(0);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JenaException je) {
            System.err.println("ERROR" + je.getMessage());
            je.printStackTrace();
            System.exit(0);
        }
        return null;
    }

    public static String execQuery3(String queryString, String what) {

        OntModel ontoModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF, null);
        try {
            InputStream in = FileManager.get().open("../instance.owl");
            try {
                OntDocumentManager dm = ontoModel.getDocumentManager();
                dm.addAltEntry( "http://www.semanticweb.org/IZ/2022/Tim12/Klase", "file:../klase.owl" );
                ontoModel.read("http://www.semanticweb.org/IZ/2022/Tim12/Klase", null, "TTL");
                ontoModel.read(in, null, "TTL");
                Query query = QueryFactory.create(queryString);
                QueryExecution quer = QueryExecutionFactory.create(query, ontoModel);
                ResultSet results = quer.execSelect();
                ArrayList<String> list = new ArrayList<String>();
                int a = 0;
                while (results.hasNext()) {
                    a = 1;
                    QuerySolution solution = results.nextSolution();
                    list.add(solution.toString().toString().split("#")[1]);
                }
                if(a!=0) {
                    return list.get(0);
                }
                else {
                    return "null";
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (JenaException je) {
            System.err.println("ERROR" + je.getMessage());
            je.printStackTrace();
            System.exit(0);
        }
        return null;
    }
}
