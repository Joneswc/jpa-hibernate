package testejpa.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class GetTasksJpa {

	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();

//		selecionar por exatamente o nome da classe e não o nome da tabela
		List<Task> tasks = manager.createQuery("select t from Task as t where t.finalizada = true").getResultList();
		for (Task task : tasks) {
			System.out.println("ID: " + task.getId() + " : DESCRICAO: " + task.getDescricao());
		}

		manager.close();
		factory.close();
	}

}
