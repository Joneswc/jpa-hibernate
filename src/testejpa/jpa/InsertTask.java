package testejpa.jpa;

import java.util.Calendar;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import testejpa.modelo.Task;

public class InsertTask {

	public static void main(String[] args) {
		Task task = new Task();
		task.setDescricao("Estudar + JPA!");
		task.setFinalizada(true);
		task.setDataFinalizacao(Calendar.getInstance());

//		DDL é sempre com EntityManageFactory
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("tasks2");
//		EntityManager gerencia suas entidades de modelo
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(task);
		manager.getTransaction().commit();

		System.out.println("Testando Jpa e Hibernate");
		System.out.println("ID da Task: " + task.getId());

		manager.close();
	}

}
