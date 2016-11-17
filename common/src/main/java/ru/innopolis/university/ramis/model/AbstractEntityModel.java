package ru.innopolis.university.ramis.model;

import java.io.Serializable;

/**
 * Created by innopolis on 17.11.16.
 */
public abstract class AbstractEntityModel implements Serializable {

    private Long version;

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
