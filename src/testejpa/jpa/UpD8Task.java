package testejpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class UpD8Task {

	public static void main(String[] args) {

		Task task = new Task();
		task.setId(5L);
		task.setDescricao("estudar muito mais JPA, ainda!");
		task.setFinalizada(false);
		task.setDataFinalizacao(null);

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(task);
		manager.getTransaction().commit();

		System.out.println("Testando UpD8 com JPA e Hibern8");
		System.out.println("ID da Task atualizada: " + task.getId());

		manager.close();

	}

}
