package br.edu.ifnmg.projets_001;

import java.util.ArrayList;
import java.util.List;


public class Teacher {
private String name;
private String specialization;
private int id;
private String sex;
public Teacher(){
    this.name = "";
    this.specialization = "";
    this.id = 0;
    this.sex = "";
}

public String getName(){
    return this.name;
}
public void setName(String new_name){
    if(new_name.length() > 4)
        this.name = new_name;
}
public String getSpecialization(){
    return this.specialization;
}
public void setSpecialization(String new_specialization){
    this.specialization = new_specialization;
}
public int getId(){
    return this.id;
}
public void setId(int new_id){
    if(new_id > 0)
        this.id = new_id;
}
public String getSex(){
    return this.sex;
}
public void setSex(String new_sex){
    if(new_sex == "M" || new_sex == "F"){
        this.sex = new_sex;
    }
}
}
