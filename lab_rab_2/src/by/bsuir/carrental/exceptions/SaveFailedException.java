package by.bsuir.carrental.exceptions;

public final class SaveFailedException extends Throwable {
    @Override
    public String getMessage() {
        return "Failed saving data";
    }
}
