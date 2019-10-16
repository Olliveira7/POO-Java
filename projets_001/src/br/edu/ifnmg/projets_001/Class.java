
package br.edu.ifnmg.projets_001;

import br.edu.ifnmg.projets_001.Teacher;
import br.edu.ifnmg.projets_001.Student;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Class {
   private int id;
   private Teacher teacher;
   private List<Student> students;
   private Date date;
   
   public Class(){
       this.id = 0;
       this.teacher = new Teacher(); //Como inicializar o teacher do tipo teacher
       this.students = new ArrayList<Student>();
       this.date = new Date(); //Como inicializar datas do tipo date 
   }
   
   public int getId(){
    return this.id;
   }
   
   public void setId(int new_id){
       if(new_id > 0)
           this.id = new_id;
   }
   
   public void addStudent(Student new_student){
       if(new_student != null)
           this.students.add(new_student);
   }
   
   private void removeStudent(Student new_student){
       if(this.students.contains(new_student))
           this.students.remove(new_student);
   }
   
   
}
