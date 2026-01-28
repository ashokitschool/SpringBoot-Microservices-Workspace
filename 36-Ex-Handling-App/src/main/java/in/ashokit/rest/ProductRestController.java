package in.ashokit.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.exception.ProductNotFoundException;

@RestController
public class ProductRestController {

	@GetMapping("/product/{id}")
	public ResponseEntity<String> getProductInfo(@PathVariable Integer id) {

		if (id > 100) {
			throw new ProductNotFoundException("Invalid ID");
		}

		return new ResponseEntity<String>("Product is Apple", HttpStatus.OK);

	}
}
