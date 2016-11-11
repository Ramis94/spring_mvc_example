package ru.innopolis.university.ramis.service.impl;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.innopolis.university.ramis.entity.Lecture;
import ru.innopolis.university.ramis.model.LectureModel;
import ru.innopolis.university.ramis.repository.LectureRepository;
import ru.innopolis.university.ramis.service.LectureService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by innopolis on 01.11.16.
 */
@Service
public class LectureServiceImpl implements LectureService {

    private MapperFacade mapperFacade = new DefaultMapperFactory.Builder().build().getMapperFacade();

    @Autowired
    LectureRepository lectureRepository;

    @Override
    public List<LectureModel> getAllLecture() throws SQLException {
        List<LectureModel> lectureModels = new ArrayList<>();
        mapperFacade.mapAsCollection(lectureRepository.findAll(), lectureModels, LectureModel.class);
        return lectureModels;
    }

    @Override
    public void addLecture(LectureModel lecture) throws SQLException {
        lectureRepository.save(mapperFacade.map(lecture, Lecture.class));
    }
}
