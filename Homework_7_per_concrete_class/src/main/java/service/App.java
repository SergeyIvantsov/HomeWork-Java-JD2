package service;

import entity.Address;
import entity.HomeTask;
import entity.Task;
import entity.WorkTask;

import javax.persistence.EntityManager;
import java.util.Date;

public class App {
    public static void main(String[] args) {
        Task task = Task.builder()
                .name("Задание")
                .description("рассчитать выручку")
                .build();
        Address address = Address.builder().street("Столетова").city("Минск").build();
        HomeTask homeTask = HomeTask
                .builder().name("Задача 3").description("Третий способ")
                .startDate(new Date(2025, 04, 07))
                .endDate(new Date(2025, 07, 25))
                .address(address)
                .build();

        WorkTask workTask = WorkTask.builder()
                .name("Песледняя")
                .description("Сделать третьим способом")
                .cost(10000.9)
                .build();

        EntityManager em2 = HibernateUtil.getEntityManager();
        em2.getTransaction().begin();
        em2.persist(task);
        em2.persist(homeTask);
        em2.persist(workTask);
        em2.getTransaction().commit();
        em2.close();
        HibernateUtil.close();

    }
}
