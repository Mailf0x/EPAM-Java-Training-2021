package service.main;

import java.util.List;

import dao.ProductDao;
import dao.DaoException;
import domain.Product;
import service.ProductService;
import service.ServiceException;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;

	public void setproductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

	@Override
	public List<Product> findAll() throws ServiceException {

		try {
			return productDao.readAll();

		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public Product findById(Long id) throws ServiceException {

		try {
			return productDao.read(id);

		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public void save(Product product) throws ServiceException {

		try {

			if( product.getId() == null ) {
				productDao.create(product);

			} else {
				productDao.update(product);
			}

		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

	@Override
	public boolean canDelete(Long productId) throws ServiceException {
		return true;
	}

	@Override
	public void delete(Long productId) throws ServiceException {

		try {
			productDao.delete(productId);

		} catch(DaoException e) {
			throw new ServiceException(e);
		}
	}

}
