package com.mateusbkps.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.mateusbkps.dao.ClienteDao;
import com.mateusbkps.entity.Cliente;

@ManagedBean
@SessionScoped
public class ClienteBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private Cliente cliente;
	private ClienteDao cd;
	private List<Cliente> ClienteList;
	
    @PostConstruct
    public void init(){
        this.cliente = new Cliente();
        this.cd = new ClienteDao();
        this.ClienteList = cd.list();
    }
    
    public String newCliente(){
        return "manageCliente";
    }
    
    public String delete(Cliente cliente){
        cd.delete(cliente);
        return "index";
    }
    
    public String edit(Cliente cliente){
    	this.cliente = cliente;
        return "manageCliente";
    }
    
    public String save() {
        cd.saveOrUpdate(cliente);
        this.cliente = new Cliente();
        return "cliente";
    }
     
    public Cliente getCliente() {
        return cliente;
    }
    
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public ClienteDao getCd() {
        return cd;
    }
    
    public void setCd(ClienteDao cd) {
        this.cd = cd;
    }
    
    public List<Cliente> getClienteList() {
        this.ClienteList = cd.list();
        return ClienteList;
    }
    
    public void setClienteList(List<Cliente> clienteList) {
       ClienteList = clienteList;
    }
    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
}
