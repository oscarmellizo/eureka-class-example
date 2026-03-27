package co.org.profamilia.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.org.profamilia.product.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
