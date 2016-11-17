package ru.innopolis.university.ramis.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

/**
 * Created by innopolis on 17.11.16.
 */
@MappedSuperclass
public abstract class AbstractEntity {

    private Long version;

    @Version
    @Column(name = "version")
    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }
}
