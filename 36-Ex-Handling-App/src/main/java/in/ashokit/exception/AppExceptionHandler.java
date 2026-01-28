package in.ashokit.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AppExceptionHandler {

	@ExceptionHandler(value = Exception.class)
	public ResponseEntity<ExInfo> handleException(Exception e) {

		ExInfo info = new ExInfo();
		info.setExCode("APP00001");
		info.setExMsg(e.getMessage());
		info.setDate(LocalDateTime.now());

		return new ResponseEntity<>(info, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(value = ProductNotFoundException.class)
	public ResponseEntity<ExInfo> handleProductException(ProductNotFoundException e) {

		ExInfo info = new ExInfo();
		info.setExCode("APP00002");
		info.setExMsg(e.getMessage());
		info.setDate(LocalDateTime.now());

		return new ResponseEntity<>(info, HttpStatus.BAD_REQUEST);
	}
}
