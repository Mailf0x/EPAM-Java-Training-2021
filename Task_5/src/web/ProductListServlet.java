package web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Product;
import locator.ServiceLocator;
import locator.ServiceLocatorException;
import service.ProductService;
import service.ServiceException;

public class ProductListServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		try( ServiceLocator locator = new ServiceLocator() ) {
			ProductService service = locator.getProductService();
			List<Product> products = service.findAll();
			req.setAttribute("products", products);
			req.getRequestDispatcher("/WEB-INF/jsp/product/list.jsp").forward(req, resp);

		} catch(ServiceLocatorException | ServiceException e) {
			throw new ServletException(e);

		} catch(Exception e) {}
	}
}
