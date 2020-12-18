package aplicattion;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class ProgramJDBC {

	public static void main(String[] args) {
		
		
		VendedorDao vendedorDao = DaoFactory.createVendedorDao();
		System.out.println("=== TEST 1: vendedor findById =====");
		Vendedor v = vendedorDao.findById(3);
		System.out.println(v);
		System.out.println("\n=== TEST 2: vendedor findByDepartment =====");
		Departamento dep=new Departamento(2,null);
		List<Vendedor> list=vendedorDao.findByDepartment(dep);
		for(Vendedor obj:list) {
			System.out.println(obj);	
		}
		System.out.println("\n=== TEST 3: vendedor findAll =====");
		 list=vendedorDao.findAll();
		for(Vendedor obj:list) {
			System.out.println(obj);
		}
	}

}
