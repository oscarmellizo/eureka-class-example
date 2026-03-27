package co.org.profamilia.invoice.service;

import co.org.profamilia.invoice.dto.InvoiceDto;
import co.org.profamilia.invoice.dto.InvoiceRequestDto;

public interface IInvoiceService {

	InvoiceDto createInvoice(InvoiceRequestDto invoiceRequest);

}
