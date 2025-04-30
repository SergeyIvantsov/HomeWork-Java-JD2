package service;

import entity.Address;
import entity.HomeTask;
import entity.Task;
import entity.WorkTask;

import javax.persistence.EntityManager;
import java.util.Date;

public class JPA {
    public static void main(String[] args) {
        Task task = Task.builder()
                .name("Написать программу")
                .description("Содержащую ввод-вывод данных")
                .build();
        Address address = Address.builder().street("Ванеева").city("Минск").build();
        HomeTask homeTask = HomeTask
                .builder().name("Задача 1").description("Что-то")
                .startDate(new Date(2024, 10, 11))
                .endDate(new Date(2024, 12, 12))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Задача X")
                .description("Сделать что-нибудь")
                .cost(8500.67)
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
