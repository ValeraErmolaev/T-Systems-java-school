package vermolae.exeptions;

public class TariffNotFoundException extends CustomDAOException{
    public TariffNotFoundException(String message) {
        super(message);
    }

    public TariffNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
