package br.com.clienteController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "clienteController")
@ViewScoped
public class ClienteController implements Serializable {

	private static final long serialVersionUID = 1529646761706419659L;

	private Cliente cliente = new Cliente();

	private List<Cliente> todosClientes = new ArrayList<Cliente>();

	public ClienteController() {
		this.todosClientes
				.add(new Cliente("João da Silva", "joao@dasilva.com"));
		this.todosClientes.add(new Cliente("Maria Abadia",
				"maria@abadia.com.br"));
//		cliente.setEmail("teste");
//		cliente.setNome("Teste");
		
	}



	public void adicionar() {
		   
		if ((!cliente.getNome().isEmpty() && !cliente.getEmail().isEmpty())) {
			this.todosClientes.add(cliente);
			this.cliente = new Cliente();
		} else {
			FacesContext context = FacesContext.getCurrentInstance();

			context.addMessage(null, new FacesMessage(
					FacesMessage.SEVERITY_ERROR, "Erro",
					"Não e possivel Cadastrar valores nulos"));
		}

		
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getTodosClientes() {
		return todosClientes;
	}



	public void setTodosClientes(List<Cliente> todosClientes) {
		this.todosClientes = todosClientes;
	}
	
	

}
