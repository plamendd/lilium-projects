package com.lilium.tutorial.api;

import com.lilium.tutorial.dto.BaseDTO;
import com.lilium.tutorial.entity.DistributedEntity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Abstract CRUDL api containing methods for handling of crudl operations.
 *
 * @param <ENTITY> Entity class.
 * @param <DTO> DRO class.
 */
public interface AbstractCRUDLApi <ENTITY extends DistributedEntity, DTO extends BaseDTO>{

    /**
     *
     * @param dto DTO to save.
     * @return Return saved  Entity as a DTO.
     */
    DTO save(DTO dto);

    /**
     * find DTO  by forwarded ID.
     *
     * @param id ID used for serching.
     * @return Returns found DTO otherwise null.
     */
    DTO getById(Integer id);

    /**
     * Lists all found DTOs.
     *
     * @return List of found DTOs.
     */
    List<DTO> list();

    /**
     * finds all entities modified since forwarded timestamp.
     * @param time Timestamp.
     * @return Returns a list of all DTOs.
     */
    List<DTO> modifiedSince(LocalDateTime time);
    /**
     *
     * Deleting Entity by given
     *
     * @param id id for deleting entity.
     * @return  returns true if entity is deleted.
     */
    Boolean delete(Integer id);
}
