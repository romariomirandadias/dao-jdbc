package aplicattion;

import java.util.Date;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class ProgramJDBC {

	public static void main(String[] args) {
		Departamento obj = new Departamento(1, "Books");
		Vendedor v = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 1800.00, obj);
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		System.out.println(v);

	}

}
