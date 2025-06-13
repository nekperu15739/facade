package org.nekperu15739.facade.api.records;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.time.OffsetDateTime;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = RecordController.class)
class RecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldAddNewUser() throws Exception {
        var resource = buildRequest();

        mockMvc.perform(post("/records")
                .contentType(APPLICATION_JSON_VALUE)
                .content(objectMapper.writeValueAsString(resource)))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().contentType(APPLICATION_JSON_VALUE))
            .andExpect(jsonPath("$.id").value(resource.id().toString()))
            .andExpect(jsonPath("$.firstname").value(resource.firstname()))
            .andExpect(jsonPath("$.lastname").value(resource.lastname()))
            .andExpect(jsonPath("$.nickname").value(resource.nickname()))
            .andExpect(jsonPath("$.password").value(resource.password()))
            .andExpect(jsonPath("$.email").value(resource.email()))
            .andExpect(jsonPath("$.country").value("UK"))
            .andExpect(jsonPath("$.createdAt").value(resource.createdAt().toString()))
            .andExpect(jsonPath("$.updatedAt").value(resource.updatedAt().toString()));
    }

    private RecordResource buildRequest() {
        var faker = new Faker();
        var name = faker.name();
        var internet = faker.internet();

        return RecordResource
            .builder()
            .id(UUID.randomUUID())
            .firstname(name.firstName())
            .lastname(name.lastName())
            .nickname(name.fullName())
            .password(internet.password())
            .email(internet.emailAddress())
            .createdAt(OffsetDateTime.now())
            .updatedAt(OffsetDateTime.now())
            .build();
    }
}
