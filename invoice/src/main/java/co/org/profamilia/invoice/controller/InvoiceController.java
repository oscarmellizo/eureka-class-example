package co.org.profamilia.invoice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.org.profamilia.invoice.feign.ProductFeign;
import co.org.profamilia.invoice.feign.dtoexternal.ProductExternalDto;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {

	@Autowired
	private ProductFeign productFeign;
	
	@GetMapping("/{id}")
	public ProductExternalDto getExternalProduct(@PathVariable Long id) {
		return productFeign.getProductExternalById(id);
	}
}
