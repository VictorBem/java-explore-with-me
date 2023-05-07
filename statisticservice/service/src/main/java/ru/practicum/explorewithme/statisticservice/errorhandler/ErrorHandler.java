package ru.practicum.explorewithme.statisticservice.errorhandler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.practicum.explorewithme.statisticservice.exception.BadRequestException;

import java.util.NoSuchElementException;

@RestControllerAdvice("ru.practicum.explorewithme.statisticservice")
@Slf4j
public class ErrorHandler {

    @ExceptionHandler({NoSuchElementException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorResponse errorResponseNotFound(RuntimeException e) {
        log.error("Ошибка: " + e.getMessage());
        return new ErrorResponse("Ошибка.", e.getMessage());
    }

    @ExceptionHandler({BadRequestException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse errorResponseValidation(RuntimeException e) {
        log.error("Ошибка: " + e.getMessage());
        return new ErrorResponse("Ошибка.", e.getMessage());
    }
}
