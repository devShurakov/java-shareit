package ru.practicum.shareit.booking.exception;

public class UserNotOwnerException extends RuntimeException  {
    public UserNotOwnerException(String message) {
        super(message);
    }
}
