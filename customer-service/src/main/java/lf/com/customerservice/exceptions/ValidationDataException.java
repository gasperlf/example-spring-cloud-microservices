package lf.com.customerservice.exceptions;

public class ValidationDataException extends RuntimeException {

    private final String code;
    public ValidationDataException(String code, String msg){
        super(msg);
        this.code = code;
    }

    public String getCode(){
        return  this.code;
    }
}
