package vermolae.exeptions;

public class RoleNotFoundException extends CustomDAOException{
    public RoleNotFoundException(String message) {
        super(message);
    }

    public RoleNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
