package com.lilium.tutorial;


import com.lilium.tutorial.dto.UserDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

public class UserRestTest {
    private static final RestTemplate REST_TEMPLATE = new RestTemplate();
    private static final String URL = "http://localhost:8080/api/users";

    @Test
    public void testUserCRUDL() {
        final UserDTO dto = new UserDTO();
        dto.setUsername("username" + UUID.randomUUID());
        dto.setName("Name" + UUID.randomUUID());

        final UserDTO saveDTO = REST_TEMPLATE.postForObject(URL, dto, UserDTO.class);
        verifyUserDTO(dto, saveDTO);

        saveDTO.setName("Update name");
        final UserDTO uodatedDTO  = REST_TEMPLATE.postForObject(URL, saveDTO, UserDTO.class);
        verifyUserDTO(saveDTO, uodatedDTO);

        final UserDTO byID = REST_TEMPLATE.getForObject(URL + "/" + saveDTO.getId(), UserDTO.class);
        verifyUserDTO(saveDTO, byID);

        final List dtos = REST_TEMPLATE.getForObject(URL + "/list", List.class);
        assertTrue(!dtos.isEmpty());

        REST_TEMPLATE.delete((URL + "/" + saveDTO.getId()));
        final UserDTO deleted = REST_TEMPLATE.getForObject(URL + "/" + saveDTO.getId(), UserDTO.class);
        assertNull(deleted);


    }

    private void verifyUserDTO(UserDTO expected, UserDTO actual) {
        assertNotNull(actual);
        assertNotNull(actual.getId());
        assertNotNull(actual.getModified());
        assertEquals(actual.getUsername(), expected.getUsername());
        assertEquals(actual.getName(), expected.getName());
    }
}
