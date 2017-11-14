package persistence;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import entity.Cliente;

public class ClienteDao  extends Dao{
	
	
	public void create(Cliente c)throws Exception{
		open();
		 stmt = con.
			 prepareStatement("insert into cliente values (null,?,?,?)");
		    stmt.setString(1,  c.getNome());
		    stmt.setString(2,  c.getEmail());
		    stmt.setString(3,  c.getSexo());
		    stmt.execute();
		  stmt.close();
		close();
	}


	
	
	public List<Cliente> findAll() throws Exception{
		open();
		  stmt = con.prepareStatement("select * from cliente");
		  rs = stmt.executeQuery();
		  List<Cliente> lst = new ArrayList<Cliente>();
		  while(rs.next()){
			  Cliente c=new Cliente();
			   c.setIdCliente(rs.getInt(1));
			   c.setNome(rs.getString(2));
			   c.setEmail(rs.getString(3));
			   c.setSexo(rs.getString(4));
			  lst.add(c);
		  }
		close();
		return lst;
	}
	
	
	public  ResultSet   findByReport() throws Exception{
		  open();
		  stmt = con.prepareStatement("select * from cliente");
		  rs= stmt.executeQuery();
		return rs;
	}

	
	
  public static void main(String[] args) {
  try {
	   System.out.println(new ClienteDao().findByReport());
    } catch (Exception ex) {
	   ex.printStackTrace();
   }
	 
}	
	
  
}


