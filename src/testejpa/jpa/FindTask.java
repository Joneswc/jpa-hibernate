package testejpa.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class FindTask {

	public static void main(String[] args) {
	
//		DDL é sempre com EntityManageFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
//		EntityManager gerencia suas entidades de modelo
		EntityManager manager = factory.createEntityManager();

		Task resultTask = manager.find(Task.class, 1L);
		System.out.println("Pesquisada task de ID " + resultTask.getId() + " e descrição " + resultTask.getDescricao());

		manager.close();

	}

}
