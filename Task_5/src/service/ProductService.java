package service;

import java.util.List;

import domain.Product;

public interface ProductService {
	List<Product> findAll() throws ServiceException;

	Product findById(Long id) throws ServiceException;

	void save(Product product) throws ServiceException;

	boolean canDelete(Long productId) throws ServiceException;

	void delete(Long productId) throws ServiceException;
}
