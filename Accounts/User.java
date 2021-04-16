package Accounts;

public class User {
    protected int customerId;
    protected String status;
    protected String type;//subtypes; here so it can be compared
    protected String address;
    protected String city;
    protected String state;
    protected int zip;
    protected String first;
    protected String last;
    
    public void setStatus(int cOb){
        if(cOb==0) status = "current";
        if(cOb==1) status = "behind";
    }

    public String getStatus(){
        return status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String[] accountToArray() {
        return new String[0];
    }
    public void setType(int index){
        if(index==0)this.type="normal";
    }
    public String getType(){
        return type;
    }
}
