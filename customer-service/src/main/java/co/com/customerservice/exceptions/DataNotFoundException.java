package co.com.customerservice.exceptions;

public class DataNotFoundException extends RuntimeException {

    private final String code;
    public DataNotFoundException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public String getCode(){
        return  this.code;
    }
}
