package aplicattion;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Vendedor;

public class ProgramJDBC {

	public static void main(String[] args) {
		
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		System.out.println("=== TEST 1: vendedor findById =====");
		Vendedor v = vendedorDao.findById(3);
		System.out.println(v);

	}

}
