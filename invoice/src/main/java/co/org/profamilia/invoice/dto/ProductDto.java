package co.org.profamilia.invoice.dto;

import javax.validation.constraints.NotBlank;

import com.sun.istack.NotNull;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductDto {

	Long id;
	
	String name;
	
	Double price;
	
	Integer quantity;
	
	Double total;
}
