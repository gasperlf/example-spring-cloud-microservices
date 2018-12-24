package lf.com.financialservice.resources.dtos;

public enum TypeMessage {

    SYSTEM("System"),DATA("Data");

    private String type;
    TypeMessage(String type){
        this.type = type;
    }

    public String getType(){
        return this.type;
    }
}
