package com.github.mangila.springrestfuljpa.persistence.entity.listener;

import lombok.extern.slf4j.Slf4j;

import javax.persistence.*;

@Slf4j
public class LifecycleListener {

    @PrePersist
    public void prePersist(Object o) {
        log.info("prePersist()" + o);
    }

    @PostPersist
    public void postPersist(Object o) {
        log.info("postPersist()" + o);
    }

    @PreRemove
    public void preRemove(Object o) {
        log.info("preRemove()" + o);
    }

    @PostRemove
    public void postRemove(Object o) {
        log.info("postRemove()" + o);
    }

    @PreUpdate
    public void preUpdate(Object o) {
        log.info("preUpdate()" + o);
    }

    @PostUpdate
    public void postUpdate(Object o) {
        log.info("postUpdate()" + o);
    }

    @PostLoad
    public void postLoad(Object o) {
        log.info("postLoad()" + o);
    }
}
