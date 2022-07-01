package protage.example.protage.similarity.cbr;

import java.util.ArrayList;
import java.util.Collection;

import protage.example.protage.similarity.model.ComputerCaseDescription;
import protage.example.protage.similarity.connector.ComputerCsvConnector;
import ucm.gaia.jcolibri.casebase.LinealCaseBase;
import ucm.gaia.jcolibri.cbraplications.StandardCBRApplication;
import ucm.gaia.jcolibri.cbrcore.Attribute;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CBRCaseBase;
import ucm.gaia.jcolibri.cbrcore.CBRQuery;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.ExecutionException;
import ucm.gaia.jcolibri.method.retrieve.RetrievalResult;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNConfig;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.NNScoringMethod;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.global.Average;
import ucm.gaia.jcolibri.method.retrieve.NNretrieval.similarity.local.Interval;
import ucm.gaia.jcolibri.method.retrieve.selection.SelectCases;

public class ComputerCbrApplication implements StandardCBRApplication {
    Connector _connector;  /** Connector object */
    CBRCaseBase _caseBase;  /** CaseBase object */

    NNConfig simConfig;  /** KNN configuration */

    ArrayList<String> response = new ArrayList<>();

    public void configure() throws ExecutionException {
        _connector =  new ComputerCsvConnector();

        _caseBase = new LinealCaseBase();  // Create a Lineal case base for in-memory organization

        simConfig = new NNConfig(); // KNN configuration
        simConfig.setDescriptionSimFunction(new Average());  // global similarity function = average

        simConfig.addMapping(new Attribute("ramCapacity", ComputerCaseDescription.class), new Interval(64));
        simConfig.addMapping(new Attribute("storageCapacity", ComputerCaseDescription.class), new Interval(1028));
        simConfig.addMapping(new Attribute("graphicsCardSpeed", ComputerCaseDescription.class), new Interval(2200));
        simConfig.addMapping(new Attribute("powerSupplyWattPower", ComputerCaseDescription.class), new Interval(1000));
        simConfig.addMapping(new Attribute("fanAirFlowCapacity", ComputerCaseDescription.class), new Interval(70));
        simConfig.addMapping(new Attribute("speakersWattPower", ComputerCaseDescription.class), new Interval(100));
        simConfig.addMapping(new Attribute("processorCores", ComputerCaseDescription.class), new Interval(8));
        simConfig.addMapping(new Attribute("price", ComputerCaseDescription.class), new Interval(2500));

        // Equal - returns 1 if both individuals are equal, otherwise returns 0
        // Interval - returns the similarity of two number inside an interval: sim(x,y) = 1-(|x-y|/interval)
        // Threshold - returns 1 if the difference between two numbers is less than a threshold, 0 in the other case
        // EqualsStringIgnoreCase - returns 1 if both String are the same despite case letters, 0 in the other case
        // MaxString - returns a similarity value depending of the biggest substring that belong to both strings
        // EnumDistance - returns the similarity of two enum values as the their distance: sim(x,y) = |ord(x) - ord(y)|
        // EnumCyclicDistance - computes the similarity between two enum values as their cyclic distance
        // Table - uses a table to obtain the similarity between two values. Allowed values are Strings or Enums. The table is read from a text file.
        // TableSimilarity(List<String> values).setSimilarity(value1,value2,similarity)
    }

    public void cycle(CBRQuery query) throws ExecutionException {
        Collection<RetrievalResult> eval = NNScoringMethod.evaluateSimilarity(_caseBase.getCases(), query, simConfig);
        eval = SelectCases.selectTopKRR(eval, 5);

        response.add("Retrieved cases:");
        int i = 1;
        for (RetrievalResult nse : eval) {
            response.add(i++ + ". " + nse.get_case().getDescription() + " -> " + nse.getEval());
        }
    }

    public void postCycle() throws ExecutionException {

    }

    public CBRCaseBase preCycle() throws ExecutionException {
        _caseBase.init(_connector);
        java.util.Collection<CBRCase> cases = _caseBase.getCases();
        for (CBRCase c: cases)
            System.out.println(c.getDescription());
        return _caseBase;
    }

    public ArrayList<String> getResponse() {
        return response;
    }

    public void setResponse(ArrayList<String> response) {
        this.response = response;
    }
}
