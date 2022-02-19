package com.lilium.tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@NoRepositoryBean
public interface DistributedRepository<ENTITY> extends JpaRepository<ENTITY, Integer> {
    List<ENTITY> findAllModifiedSince(final LocalDateTime time);
}
