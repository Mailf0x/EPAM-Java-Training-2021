package locator;

import java.sql.Connection;
import java.sql.SQLException;

import dao.ProductDao;
import dao.fake.ProductDaoFakeImpl;
import dao.fake.MyConnection;
import service.ProductService;
import service.main.ProductServiceImpl;

public class ServiceLocator implements AutoCloseable {
	private ProductService productService;

	public ProductService getProductService() throws ServiceLocatorException {

		if(productService == null) {
			ProductServiceImpl service = new ProductServiceImpl();
			service.setProductDao( getProductDao() );
			productService = service;
		}
		return productService;
	}

	private ProductDao productDao;

	public ProductDao getProductDao() throws ServiceLocatorException {

		if(productDao == null) {
			ProductDaoFakeImpl dao = new ProductDaoFakeImpl();
			dao.setConnection( getConnection() );
			productDao = dao;
		}
		return productDao;
	}

	private Connection connection;

	public Connection getConnection() throws ServiceLocatorException {

		if(connection == null) {

			try {
				connection = new MyConnection();

			} catch(SQLException e) {
				throw new ServiceLocatorException(e);
			}
		}
		return connection;
	}

	@Override
	public void close() throws Exception {
		connection.close();
	}
}
