package com.lilium.tutorial.converter;

import com.lilium.tutorial.dto.BaseDTO;
import com.lilium.tutorial.entity.DistributedEntity;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Abstract converter  used to convert from ENTITY to DTO.
 *
 * @param <ENTITY> Entity to convert.
 * @param <DTO> DTO in which we are converting.
 */
public   abstract class AbstractDTOConverter <ENTITY extends DistributedEntity, DTO extends BaseDTO> {
    /**
     * Convert forwarded entity into DTO.
     *
     * @param entity Entity to convert.
     * @return Converted entity as DTO.
     */
    public abstract  DTO convert(final ENTITY entity);

    /**
     *  Converted forwarded Entity to converted DTO.
     *
     * @param entity Entity to convert.
     * @param dto   DTO in which we are converting.
     */
    public void convert(final ENTITY entity, final DTO dto ) {
        dto.setId(entity.getId());
        dto.setCreated(entity.getCreated());
        dto.setModified(entity.getModified());
    }

    /**
     * Convert forwarded entities int Lists of DTOS
     *
     * @param entities Entities to convert.
     * @return List of DTOs
     */
    public List<DTO> convertList(final List<ENTITY> entities){
        if (CollectionUtils.isEmpty(entities)) {
            return Collections.emptyList();
        }
       return entities.stream()
               .sequential()
               .map(this::convert)
               .collect(Collectors.toList());
    }

}
