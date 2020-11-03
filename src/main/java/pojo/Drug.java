package pojo;


/**
 * 这个类是用来封装tb_drug表的数据
 * tb_user 表字段可以写成这个实体类的成员变量
 */

public class Drug {

    private  Integer  drugId;
    private String drugName;
    private String drugPrice;
    private  String drugUser;


    public Integer getDrugId() {
        return drugId;
    }

    public void setDrugId(Integer drugId) {
        this.drugId = drugId;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getDrugPrice() {
        return drugPrice;
    }

    public void setDrugPrice(String drugPrice) {
        this.drugPrice = drugPrice;
    }

    public String getDrugUser() {
        return drugUser;
    }

    public void setDrugUser(String drugUser) {
        this.drugUser = drugUser;
    }

    @Override
    public String toString() {
        return "Drug{" +
                "drugId=" + drugId +
                ", drugName='" + drugName + '\'' +
                ", drugPrice='" + drugPrice + '\'' +
                ", drugUser='" + drugUser + '\'' +
                '}';
    }
}
