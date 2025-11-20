package in.ashokit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.ashokit.entity.Product;
import in.ashokit.repo.ProductRepo;

@Service
public class ProductService {

	@Autowired
	private ProductRepo productRepo;

	public void saveProduct() {

		Product p = new Product();

		p.setProductId(101);
		p.setProductName("Mouse");
		p.setProductPrice(500.00);

		productRepo.save(p); // auto-commit
	}

	public void updateProduct() {

		Product p = new Product();

		p.setProductId(101);
		p.setProductName("Mouse");
		p.setProductPrice(800.00);

		productRepo.save(p); // auto-commit
	}
}
