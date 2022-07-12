package protage.example.protage.similarity.connector;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collection;
import java.util.LinkedList;

import protage.example.protage.similarity.model.ComputerCaseDescription;
import ucm.gaia.jcolibri.cbrcore.CBRCase;
import ucm.gaia.jcolibri.cbrcore.CaseBaseFilter;
import ucm.gaia.jcolibri.cbrcore.Connector;
import ucm.gaia.jcolibri.exception.InitializingException;
import ucm.gaia.jcolibri.util.FileIO;

public class ComputerCsvConnector implements Connector {

    @Override
    public Collection<CBRCase> retrieveAllCases() {
        LinkedList<CBRCase> cases = new LinkedList<>();

        try {
            String file = "./src/main/java/protage/example/protage/similarity/data/computers.csv";
            BufferedReader br = new BufferedReader(new InputStreamReader(FileIO.openFile(file)));
            if (br == null)
                throw new Exception("Error opening file");

            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.startsWith("#") || (line.length() == 0))
                    continue;
                String[] values = line.split(";");

                CBRCase cbrCase = new CBRCase();

                ComputerCaseDescription computerCaseDescription = new ComputerCaseDescription();

                computerCaseDescription.setRamCapacity(Integer.parseInt(values[0]));
                computerCaseDescription.setStorageCapacity(Integer.parseInt(values[1]));
                computerCaseDescription.setGraphicsCardSpeed(Integer.parseInt(values[2]));
                computerCaseDescription.setPowerSupplyWattPower(Integer.parseInt(values[3]));
                computerCaseDescription.setFanAirFlowCapacity(Integer.parseInt(values[4]));
                computerCaseDescription.setSpeakersWattPower(Integer.parseInt(values[5]));
                computerCaseDescription.setProcessorCores(Integer.parseInt(values[6]));
                computerCaseDescription.setPrice(Integer.parseInt(values[7]));

                cbrCase.setDescription(computerCaseDescription);
                cases.add(cbrCase);
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cases;
    }

    @Override
    public Collection<CBRCase> retrieveSomeCases(CaseBaseFilter arg0) {
        return null;
    }

    @Override
    public void storeCases(Collection<CBRCase> arg0) {
    }

    @Override
    public void close() {
    }

    @Override
    public void deleteCases(Collection<CBRCase> arg0) {
    }

    @Override
    public void initFromXMLfile(URL arg0) throws InitializingException {
    }

}