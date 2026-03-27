package co.org.profamilia.product.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import co.org.profamilia.product.entity.Product;
import co.org.profamilia.product.repository.ProductRepository;
import co.org.profamilia.product.service.IProductService;

@Service
public class ProductService implements IProductService{

	@Autowired
	private Environment env;
	
	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public Product getProductById(Long id) {
		Product product = productRepository.findById(id).orElseThrow();
		product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		return product;
	}

}
