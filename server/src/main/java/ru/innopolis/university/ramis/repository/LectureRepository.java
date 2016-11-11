package ru.innopolis.university.ramis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.university.ramis.entity.Lecture;

import java.util.List;

/**
 * Created by innopolis on 09.11.16.
 */
public interface LectureRepository extends CrudRepository<Lecture, Integer> {

    List<Lecture> findAll();
}
