package aplicattion;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class ProgramJDBC2 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		DepartamentoDao departamentoDao = DaoFactory.createDepartamentoDao();
		System.out.println("=== TEST 1: departamento findById =====");
		Departamento d = departamentoDao.findById(1);
		System.out.println(d);
		System.out.println("\n=== TEST 2: departamento findAll =====");
		List<Departamento> list=departamentoDao.findAll();
		for(Departamento d1:list) {
			System.out.println(d1);
		}
		System.out.println("\n=== TEST 3: vendedor insert =====");
		Departamento newDepartamento=new Departamento(null,"Música");
		departamentoDao.insert(newDepartamento);
		System.out.println("Inserido ! Novo Id = " + newDepartamento);
		System.out.println("\n=== TEST 4: departamento update =====");
		d=departamentoDao.findById(8);
		d.setName("Futebol");
		departamentoDao.update(d);
		System.out.println("Update Completed !");
		System.out.println("\n=== TEST 5: departamento delete =====");
		System.out.println("Entre com o ID a ser deletado :");
		int id=sc.nextInt();
		departamentoDao.deleteById(id);
		System.out.println("Delete Completed !");
	}

}
