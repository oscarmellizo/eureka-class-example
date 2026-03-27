package co.org.profamilia.invoice.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.org.profamilia.invoice.dto.InvoiceDto;
import co.org.profamilia.invoice.dto.InvoiceRequestDto;
import co.org.profamilia.invoice.dto.ProductDto;
import co.org.profamilia.invoice.feign.ProductFeign;
import co.org.profamilia.invoice.feign.dtoexternal.ProductExternalDto;
import co.org.profamilia.invoice.service.IInvoiceService;

@Service
public class InvoiceService implements IInvoiceService {

	@Autowired
	private ProductFeign productFeign;
	
	@Override
	public InvoiceDto createInvoice(InvoiceRequestDto invoiceRequest) {
		List<ProductDto> productDtos = new ArrayList<>();
		invoiceRequest.getItems().stream().forEach(item -> {
			ProductExternalDto productExternal = productFeign.getProductExternalById(item.getProductId());
			ProductDto productDto = new ProductDto(productExternal.getId(), productExternal.getName(), productExternal.getPrice(), item.getQuantity(), productExternal.getPrice() * item.getQuantity());
			productDtos.add(productDto);
		});
		
		
		return new InvoiceDto(null, invoiceRequest.getClientName(), invoiceRequest.getDate(), productDtos);
	}

}
