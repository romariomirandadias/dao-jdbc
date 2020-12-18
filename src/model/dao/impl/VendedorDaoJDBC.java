package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;
import model.entities.Vendedor;

public class VendedorDaoJDBC implements VendedorDao{

	private Connection conn;
	
	public VendedorDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) {
		// TODO Auto-generated method stub
		
	}


	public Vendedor findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Name as DepName "
					+ "FROM vendedor INNER JOIN departamento "
					+ "ON vendedor.DepartmentId = departamento.Id "
					+ "WHERE vendedor.Id = ?");

			st.setInt(1, id);
			rs = st.executeQuery();
			if (rs.next()) {
			Departamento dep=instantiateDepartment(rs);
				Vendedor obj=instantiateVendedor(rs,dep);
				return obj;
			}
			return null;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Vendedor instantiateVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Nome"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalario_base(rs.getDouble("Salario_base"));
		obj.setData_aniversario(rs.getDate("Data_aniversario"));
		obj.setDepartamento(dep);
		return obj;
	}

	private Departamento instantiateDepartment(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setName(rs.getString("DepName"));
		return dep;
	}

	@Override
	public List<Vendedor> findAll() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Name as DepName "
							+ "FROM vendedor INNER JOIN departamento "
							+ "ON vendedor.DepartmentId = departamento.Id "
							+ "ORDER BY Name");

	
			rs = st.executeQuery();
			List<Vendedor> list=new ArrayList<>();
			Map<Integer,Departamento> map=new HashMap<>();
			while (rs.next()) {
			Departamento dep=map.get(rs.getInt("DepartmentId"));
			if(dep==null) {
				dep=instantiateDepartment(rs);
				map.put(rs.getInt("DepartmentId"), dep);
			}
				Vendedor obj=instantiateVendedor(rs,dep);
				list.add(obj);
				
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Vendedor> findByDepartment(Departamento department) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement(
					"SELECT vendedor.*,departamento.Name as DepName "
							+ "FROM vendedor INNER JOIN departamento "
							+ "ON vendedor.DepartmentId = departamento.Id "
							+ "WHERE DepartmentId = ? "
							+ "ORDER BY Name");

			st.setInt(1, department.getId());
			rs = st.executeQuery();
			List<Vendedor> list=new ArrayList<>();
			Map<Integer,Departamento> map=new HashMap<>();
			while (rs.next()) {
			Departamento dep=map.get(rs.getInt("DepartmentId"));
			if(dep==null) {
				dep=instantiateDepartment(rs);
				map.put(rs.getInt("DepartmentId"), dep);
			}
				Vendedor obj=instantiateVendedor(rs,dep);
				list.add(obj);
				
			}
			return list;
		}
		catch (SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

}
