package by.bsuir.carrental.exceptions;

public final class DaoGetException extends Throwable {
    @Override
    public String getMessage() {
        return "Error getting object";
    }
}
