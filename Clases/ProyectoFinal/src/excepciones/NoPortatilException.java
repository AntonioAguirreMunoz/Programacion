package excepciones;

public class NoPortatilException extends Exception {
    @Override
    public String getMessage() {
        return "No portatil";
    }
}
