package testejpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class DelTask {

	public static void main(String[] args) {

//		DDL é sempre com EntityManageFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
//		EntityManager gerencia suas entidades de modelo
		EntityManager manager = factory.createEntityManager();

		Task resultTask = manager.find(Task.class, 1L);

		manager.getTransaction().begin();
		manager.remove(resultTask);
		manager.getTransaction().commit();

		System.out.println("Teste Del com JPA");
		System.out.println("ID da Task excluída: " + resultTask.getId());

		manager.close();

	}

}
