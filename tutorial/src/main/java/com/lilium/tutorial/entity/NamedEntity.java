package com.lilium.tutorial.entity;

import com.lilium.tutorial.entity.DistributedEntity;

import javax.persistence.MappedSuperclass;


@MappedSuperclass
public abstract class NamedEntity  extends DistributedEntity {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
