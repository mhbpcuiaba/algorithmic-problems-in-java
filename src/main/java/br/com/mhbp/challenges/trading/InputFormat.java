package br.com.mhbp.challenges.trading;

import java.util.List;

public class InputFormat {

    //private int testCaseNumber;
    private int noOfPiles;
    private List<PileOfFlut> pileOfFluts;


    /*
     * public int getTestCaseNumber() { return testCaseNumber; }
     *
     *
     * public void setTestCaseNumber(int testCaseNumber) { this.testCaseNumber =
     * testCaseNumber; }
     */


    public int getNoOfPiles() {
        return noOfPiles;
    }


    public void setNoOfPiles(int noOfPiles) {
        this.noOfPiles = noOfPiles;
    }


    public List<PileOfFlut> getPileOfFluts() {
        return pileOfFluts;
    }


    public void setPileOfFluts(List<PileOfFlut> pileOfFluts) {
        this.pileOfFluts = pileOfFluts;
    }


    class PileOfFlut{
        private int numberOfBoxes;
        private List<Integer> fluts;
        public int getNumberOfBoxes() {
            return numberOfBoxes;
        }
        public void setNumberOfBoxes(int numberOfBoxes) {
            this.numberOfBoxes = numberOfBoxes;
        }
        public List<Integer> getFluts() {
            return fluts;
        }
        public void setFluts(List<Integer> fluts) {
            this.fluts = fluts;
        }

    }
}
