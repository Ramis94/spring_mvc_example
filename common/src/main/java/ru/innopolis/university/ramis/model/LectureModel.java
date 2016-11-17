package ru.innopolis.university.ramis.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * Created by innopolis on 01.11.16.
 */
public class LectureModel extends AbstractEntityModel implements Serializable {

    private Integer id;

    private String topic;

    private String description;

    private Date date;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
