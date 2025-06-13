package org.nekperu15739.facade.api.records;

import lombok.Builder;

import java.time.OffsetDateTime;
import java.util.UUID;

import static java.util.Optional.ofNullable;

@Builder
public record RecordResource(
    UUID id,
    String firstname,
    String lastname,
    String nickname,
    String password,
    String email,
    String country,
    OffsetDateTime createdAt,
    OffsetDateTime updatedAt) {

    public RecordResource {
        country = ofNullable(country)
            .orElse("UK");
    }

}
