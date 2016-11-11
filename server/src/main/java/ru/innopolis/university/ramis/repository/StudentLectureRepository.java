package ru.innopolis.university.ramis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.innopolis.university.ramis.entity.StudentLecture;

import java.util.List;

/**
 * Created by innopolis on 09.11.16.
 */
public interface StudentLectureRepository extends CrudRepository<StudentLecture, Integer> {

    List<StudentLecture> findAll();
}
