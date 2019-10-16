package br.edu.ifnmg.projets_001;

import br.edu.ifnmg.projets_001.Teacher;
import br.edu.ifnmg.projets_001.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    private String name_event;
    private int id;
    private List<Teacher> teachers;
    private List<Student> students;
    private Date date;
    
    public Event(){
        this.name_event = "";
        this.id = 0;
        this.students = new ArrayList<Student>();
        this.teachers = new ArrayList<Teacher>();
        this.date = new Date(); // Perguntar pro professor se essa é a forma correta 
    }
    
    public String getName_event(){
        return this.name_event;
    }
    
    public void setName_evet(String new_name_event){
        if(new_name_event != null)
            this.name_event = new_name_event;
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setId(int new_id){
        if(new_id > 0)
            this.id = new_id;
    }
}
