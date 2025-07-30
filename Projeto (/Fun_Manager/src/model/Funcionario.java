package model;

public class Funcionario {
	    private int id;
	    private String nome;
	    private String cargo;
	    private double salario;

	    public Funcionario(int id, String nome, String cargo, double salario) {
	        this.id = id;
	        this.nome = nome;
	        this.cargo = cargo;
	        this.salario = salario;
	    }

	    public Funcionario(String nome, String cargo, double salario) {
	        this.nome = nome;
	        this.cargo = cargo;
	        this.salario = salario;
	    }

	    // Getters e Setters
	    
	    //para ID
	    public int getId() {
	    	return id;	
	    }
	    
	    public void setId(int id) {
	    	this.id = id;
	    }
	    //para Nome
	    
	    public String getNome() {
	    	return nome;
	    }

	    public void setNome(String nome) {
	    	this.nome = nome;
	    }
	    //para Cargo
	    public String getCargo() {
	    	return cargo;
	    }
	    
	    public void setCargo(String cargo) {
	    	this.cargo = cargo;
	    }
	    
	    //para Salario
	    
	    public double getSalario() {
	    	return salario;
	    }
	    
	    public void setSalario(double salario) {
	    	this.salario = salario;
	    }
}
