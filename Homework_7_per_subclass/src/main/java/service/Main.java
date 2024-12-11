package service;

import entity.Address;
import entity.HomeTask;
import entity.Task;
import entity.WorkTask;

import javax.persistence.EntityManager;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Task task = Task.builder()
                .name("ПО")
                .description("считающее з/п")
                .build();
        Address address = Address.builder().street("Ангарская").city("Минск").build();
        HomeTask homeTask = HomeTask
                .builder().name("Задача 2").description("Второй способ")
                .startDate(new Date(2025, 12, 12))
                .endDate(new Date(2025, 14, 12))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Следующая задача")
                .description("Сделать вторым способом")
                .cost(7000.5)
                .build();

        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(task);
        em.persist(homeTask);
        em.persist(workTask);
        em.getTransaction().commit();

        HibernateUtil.close();

    }
}
