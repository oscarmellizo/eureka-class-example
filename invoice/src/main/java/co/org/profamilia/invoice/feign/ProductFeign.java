package co.org.profamilia.invoice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import co.org.profamilia.invoice.feign.dtoexternal.ProductExternalDto;

@FeignClient(name = "product-service")
public interface ProductFeign {

	@GetMapping("/products/{id}")
	public ProductExternalDto getProductExternalById(@PathVariable Long id);
}
