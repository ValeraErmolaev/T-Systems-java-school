package vermolae.exeptions;

public class DatabaseOfNumbersIsFull extends CustomDAOException{
    public DatabaseOfNumbersIsFull(String message) {
        super(message);
    }

    public DatabaseOfNumbersIsFull(String message, Throwable throwable) {
        super(message, throwable);
    }
}
