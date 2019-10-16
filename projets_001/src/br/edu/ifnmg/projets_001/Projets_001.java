
package br.edu.ifnmg.projets_001;

import br.edu.ifnmg.projets_001.percistence.repository_aluno;

public class Projets_001 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Student a1 = new Student();
       a1.setName("Diego");
       a1.setCpf("192.111.111-1");
       repository_aluno repo = new repository_aluno();
       repo.Salvar(a1);
    }
    
}
