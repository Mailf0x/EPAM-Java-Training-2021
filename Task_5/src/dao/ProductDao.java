package dao;

import java.util.List;

import domain.Product;

public interface ProductDao extends Dao<Product> {
	List<Product> readAll() throws DaoException;
}
