package ru.innopolis.university.ramis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.university.ramis.entity.Users;

/**
 * Created by innopolis on 09.11.16.
 */
public interface UserRepository extends CrudRepository<Users, Integer> {

    Users findByLogin(String login);
}

/*
*   программа обучения. перечислить проекты. 1- первая неделя 2- вторая неделя
*   личные качества(стрессоустойчивость...
*   достижения
*
*   опыт: все что связанно с программированием
*   во время обучения выполнял проекты:...
*
*   нужно писать результатоориентрованность
*
 */