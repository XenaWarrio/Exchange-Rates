package dx.queen.projectwithguys.Model;

public class Value {
    String valueName;
    String currentBuy;
    String currentSale;

    public Value(String valueName, String currentBuy, String currentSale){
        this.valueName = valueName;
        this.currentBuy = currentBuy;
        this.currentSale = currentSale;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public String getCurrentBuy() {
        return currentBuy;
    }

    public void setCurrentBuy(String currentBuy) {
        this.currentBuy = currentBuy;
    }

    public String getCurrentSale() {
        return currentSale;
    }

    public void setCurrentSale(String currentSale) {
        this.currentSale = currentSale;
    }


}
