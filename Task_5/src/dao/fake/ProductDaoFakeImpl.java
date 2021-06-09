package dao.fake;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import dao.DaoException;
import domain.Product;

public class ProductDaoFakeImpl implements ProductDao {
	private static Map<Long, Product> products = new HashMap<>();

	static {
		createProduct( build("Товар 1", 150.0) );
		createProduct( build("Товар 2", 200.0) );
		createProduct( build("Товар 3", 100.0) );
	}

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Long create(Product product) throws DaoException {
		return createProduct(product);
	}

	@Override
	public Product read(Long id) throws DaoException {
		return products.get(id);
	}

	@Override
	public void update(Product product) throws DaoException {
		products.put( product.getId(), product );
	}

	@Override
	public void delete(Long id) throws DaoException {
		products.remove(id);
	}

	@Override
	public List<Product> readAll() throws DaoException {
		return new ArrayList<>( products.values() );
	}

	private static Product build(String name, Double cost) {
		Product product = new Product();
		product.setName(name);
		product.setCost(cost);
		return product;
	}

	private static Long createProduct(Product product) {
		Long maxId = 0L;

		if( !products.isEmpty() ) {
			maxId = Collections.max( products.keySet() );
		}
		maxId++;
		product.setId(maxId);
		products.put(maxId, product);
		return maxId;
	}
}
