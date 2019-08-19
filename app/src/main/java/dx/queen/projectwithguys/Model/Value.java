package dx.queen.projectwithguys.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Value {

    public Value(String ccy, String buy, String sale){
        this.ccy = ccy;
        this.buy = buy;
        this.sale = sale;
    }

    public Value(){}

    @SerializedName("ccy")
    @Expose
    private String ccy;

    @SerializedName("buy")
    @Expose
    private String buy;
    @SerializedName("sale")
    @Expose
    private String sale;

    public String getValueName() {
        return ccy;
    }

    public void setValueName(String ccy) {
        this.ccy = ccy;
    }

    public String getBuy() {
        return buy;
    }

    public void setBuy(String buy) {
        this.buy = buy;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }




}
