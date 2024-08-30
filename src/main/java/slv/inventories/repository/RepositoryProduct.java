package slv.inventories.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import slv.inventories.model.Product;

public interface RepositoryProduct extends JpaRepository <Product, Integer> {
}
