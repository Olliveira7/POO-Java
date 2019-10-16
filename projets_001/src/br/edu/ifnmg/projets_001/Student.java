package br.edu.ifnmg.projets_001;


import java.util.ArrayList;
import java.util.List;


public class Student {
    private int id;
    private String cpf;
    private String name;
    private String name_mother;
    private String name_father;
    private String nome;
    private List<String> telefones;
    private String street; //rua
    private String neighborhood; // bairro
    private String number_house;
    public Student(){   //Esse é um método, então quando acabar as variáveis dentro das aspas irão ser encerradas, mas as q estão inicialidas com o this não irão ser encerradas 
        this.id=0; //Esse método é um contrutor, serve para inicializar as variáveis
        this.name="";
        this.name_mother="";
        this.name_father="";
        this.cpf="";
        this.street="";
        this.neighborhood="";
        this.number_house="";
        this.telefones = new ArrayList<String>(); //Coloca new pq ele é objeto de outra classe
    }
    public int getId(){
        return this.id;
    }
    public void setId(int id){
        if(id > 0)
            this.id = id;
    }
    public String getCpf(){
        return this.cpf;
    }
    public void setCpf(String new_cpf){
        this.cpf = new_cpf;
    }
     public String getName(){
        return this.name;
    }
    public void setName(String new_name){
        if(new_name.length() > 4)
            this.name = new_name;
    }
    public String getName_father(){
        return this.name_father;
    }
    public void setName_father(String new_name_father){
        if(new_name_father.length() > 4)
            this.name_father = new_name_father;
    }
    public String getName_mother(){
        return this.name_mother;
    }
    public void setName_mother(String new_name_mother){
        if(new_name_mother.length() > 4)
            this.name_mother = new_name_mother;
    }
    public String getStreet(){
        return this.street;
    }
    public void setStreet(String new_street){
            this.street = new_street;
    }
    public String getNeighborhood(){
        return this.neighborhood;
    }
    public void setNeighborhood(String new_neighborhood){
            this.neighborhood = new_neighborhood;
    }
    public void addTelefone(String telefone){
        if(telefone != null && telefone.length() == 11) // o método length retorna o tamanho da string
            this.telefones.add(telefone);
    }
    public void removeTelefone(String telefone){
        if(this.telefones.contains(telefone))// o cantais faz um for e compara com tds os dados da lista
            this.telefones.remove(telefone);
    }
    @Override
    public String toString() { 
        return "Student{" + "id=" + id + ", name=" + name + ", name_mother=" + name_mother + ", name_father=" + name_father + ", nome=" + name + ", telefones=" + telefones + '}';
    }
    
}
