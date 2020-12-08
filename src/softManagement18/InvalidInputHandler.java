package softManagement18;

public class InvalidInputHandler extends  RuntimeException {
    private String message;


    public InvalidInputHandler(String message) throws RuntimeException {
        super(message);
    }

}
