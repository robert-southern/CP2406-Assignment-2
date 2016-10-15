import java.util.ArrayList;

public class Player {

    private boolean dealer = false;
    private boolean human = false;
    private String name = "";
    private String tempName = "";
    private ArrayList<Card> hand = new ArrayList();
    boolean canPlay = true;

    public Player() {

    }

    public boolean isDealer() {
        return dealer;
    }

    public void setDealer(boolean dealer) {
        this.dealer = dealer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHuman() {
        return human;
    }

    public void setHuman(boolean val) {
        this.human = val;
        if (this.human == true) {
            this.name = "Player";
            this.tempName = "Player";
        }

    }

    public String getTempName() {
        return tempName;
    }

    public void setTempName(String tempName) {
        this.tempName = tempName;
    }

    public void giveCard(Card card) {
        this.hand.add(card);
    }

    public ArrayList<Card> getHand() {
        return hand;
    }


    public boolean isCanPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }
}
