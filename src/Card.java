
/*  - Here we have an object used to represent a single card.
    - Contains information about the card.
    - Records whether or not the card has been played. (maybe)
 */


import java.util.DoubleSummaryStatistics;

public class Card {

    private String name = "";
    private double hardness = 0;
    private String hardnessString = "";
    private double specificGravity = 0;
    private String specificGravityString = "";
    private int cleavage = 0;
    private String cleavageType = "";
    private int abundance = 0;
    private String abundanceType = "";
    private int econValue = 0;
    private String econValueType = "";
    private boolean Played = false;
    private boolean superTrumpCard = false;
    private double[] values;

    public Card() {

    }

    public Card(String name) {
        this.name = name;
    }


    public Card(String name, double hardness, double specificGravity, int cleavage, int abundance, int econValue) {
        this.name = name;
        this.hardness = hardness;
        this.specificGravity = specificGravity;
        this.cleavage = cleavage;
        this.abundance = abundance;
        this.econValue = econValue;

        this.hardnessString = Double.toString(hardness);
        this.specificGravityString = Double.toString(specificGravity);

        this.values = new double[5];
        this.values[0] = hardness;
        this.values[1] = specificGravity;
        this.values[2] = cleavage;
        this.values[3] = abundance;
        this.values[4] = econValue;

        switch (cleavage) {
            case 0:
                this.cleavageType = "none";
                break;
            case 1:
                this.cleavageType = "poor/none";
                break;
            case 2:
                this.cleavageType = "1 poor";
                break;
            case 3:
                this.cleavageType = "2 poor";
                break;
            case 4:
                this.cleavageType = "1 good";
                break;
            case 5:
                this.cleavageType = "1 good, 1 poor";
                break;
            case 6:
                this.cleavageType = "2 good";
                break;
            case 7:
                this.cleavageType = "3 good";
                break;
            case 8:
                this.cleavageType = "1 perfect";
                break;
            case 9:
                this.cleavageType = "1 perfect, 1 good";
                break;
            case 10:
                this.cleavageType = "1 perfect, 2 good";
                break;
            case 11:
                this.cleavageType = "2 perfect, 1 good";
                break;
            case 12:
                this.cleavageType = "3 perfect";
                break;
            case 13:
                this.cleavageType = "4 perfect";
                break;
            case 14:
                this.cleavageType = "6 perfect";
                break;
        }

        switch (abundance) {
            case 0:
                this.abundanceType = "ultratrace";
                break;
            case 1:
                this.abundanceType = "trace";
                break;
            case 2:
                this.abundanceType = "low";
                break;
            case 3:
                this.abundanceType = "moderate";
                break;
            case 4:
                this.abundanceType = "high";
                break;
            case 5:
                this.abundanceType = "very high";
                break;
        }

        switch (econValue) {
            case 0:
                this.econValueType = "trivial";
                break;
            case 1:
                this.econValueType = "low";
                break;
            case 2:
                this.econValueType = "moderate";
                break;
            case 3:
                this.econValueType = "high";
                break;
            case 4:
                this.econValueType = "very high";
                break;
            case 5:
                this.econValueType = "I'm rich!";
                break;
        }
    }


    public void displayCard() {

        if (this.isSuperTrumpCard()) {
            System.out.println("--------------|" + this.name + "|--------------");
            System.out.println("              <TRUMP CARD>               ");
            System.out.println("");
            System.out.println("          *Special qualities             ");
            System.out.println("");
            System.out.println("");
            System.out.println("-----------------------------------------");
        } else {
            System.out.println("--------------|" + this.name + "|--------------");
            System.out.println("- Hardness:  " + this.hardness);
            System.out.println("- Specific Gravity:  " + this.specificGravity);
            System.out.println("- Cleavage:  " + this.cleavageType);
            System.out.println("- Crustal Abundance  " + this.abundanceType);
            System.out.println("- Economic Value:  " + this.econValueType);
            System.out.println("-----------------------------------------");
        }
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHardness() {
        return hardness;
    }

    public void setHardness(double hardness) {
        this.hardness = hardness;
    }

    public double getSpecificGravity() {
        return specificGravity;
    }

    public void setSpecificGravity(double specificGravity) {
        this.specificGravity = specificGravity;
    }

    public int getCleavage() {
        return cleavage;
    }

    public void setCleavage(int cleavage) {
        this.cleavage = cleavage;
    }

    public int getAbundance() {
        return abundance;
    }

    public void setAbundance(int abundance) {
        this.abundance = abundance;
    }

    public int getEconValue() {
        return econValue;
    }

    public void setEconValue(int econValue) {
        this.econValue = econValue;
    }

    public boolean wasPlayed() {
        return Played;
    }

    public void setWasPlayed(boolean wasPlayed) {
        this.Played = wasPlayed;
    }

    public boolean isSuperTrumpCard() {
        return superTrumpCard;
    }

    public void setSuperTrumpCard(boolean isSuperTrump) {
        this.superTrumpCard = isSuperTrump;
    }

    public double[] getValues() {
        return values;
    }

    public String getCleavageType() {
        return cleavageType;
    }

    public String getAbundanceType() {
        return abundanceType;
    }

    public String getEconValueType() {
        return econValueType;
    }
}
