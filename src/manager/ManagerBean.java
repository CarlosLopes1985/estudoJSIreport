package manager;

import java.io.InputStream;
import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import entity.Cliente;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperRunManager;
import persistence.ClienteDao;

@ManagedBean(name="mb")
@RequestScoped
public class ManagerBean implements Serializable {
	private static final long serialVersionUID = 1L;
	 
	private Cliente cliente;
	 
	 @PostConstruct
	 public void init(){
		 cliente = new Cliente();	
	 }

     public Cliente getCliente() {
		return cliente;
	}
	
     
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public String relatorio(){
		try{
		  InputStream  arquivo = FacesContext.getCurrentInstance().
			         getExternalContext().getResourceAsStream("/relatorio1.jasper");
		  JRResultSetDataSource jrrs=
                    new JRResultSetDataSource(new ClienteDao().findByReport()); 

		  byte pdf[]= JasperRunManager.runReportToPdf(arquivo,null, jrrs);

		  HttpServletResponse response =  (HttpServletResponse) 
		    FacesContext.getCurrentInstance().getExternalContext().getResponse();
		
	    ServletOutputStream out= response.getOutputStream();
		       out.write(pdf);
		       out.flush();
		       out.close();
	  FacesContext.getCurrentInstance().responseComplete();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		
		return null;
	}
	
	
	
	
	public void gravar(){
		FacesContext fc = FacesContext.getCurrentInstance();
		  try{
			
			  ClienteDao cd = new ClienteDao();
			//gravar
			  cd.create(cliente); 
			  //Mensagem
			  fc.addMessage("form1", new FacesMessage("Dados Gravados ..."));
			  //limpar os Dados
			   cliente = new Cliente();
		    }catch(Exception ex){
			   ex.printStackTrace();
		    }
	}

	
}
