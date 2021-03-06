package aplicattion;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class ProgramJDBC {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
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
		System.out.println("\n=== TEST 4: vendedor insert =====");
		Vendedor newVendedor=new Vendedor(null,"Greg","greg@gmail.com",new java.util.Date(),4000.00,dep);
		vendedorDao.insert(newVendedor);
		System.out.println("Inserido ! Novo Id = " + newVendedor);
		System.out.println("\n=== TEST 5: vendedor update =====");
		v=vendedorDao.findById(1);
		v.setNome("Marta Waine");
		vendedorDao.update(v);
		System.out.println("Update Completed !");
		System.out.println("\n=== TEST 6: vendedor delete =====");
		System.out.println("Entre com o ID a ser deletado :");
		int id=sc.nextInt();
		vendedorDao.deleteById(id);
		System.out.println("Delete Completed !");
	}

}
