package org.nekperu15739.facade.api.lombok;

import lombok.Builder;
import lombok.Getter;
import lombok.extern.jackson.Jacksonized;

import java.time.OffsetDateTime;
import java.util.UUID;

/**
 * Default value using lombok:
 * Add @Builder.Default to set a default value
 * Use @Jacksonized use default values on unserialize when builds object using builder
 */
@Getter
@Builder
@Jacksonized
public class InmutableLombokResource {

    private final UUID id;
    private final String firstname;
    private final String lastname;
    private final String nickname;
    private final String password;
    private final String email;

    @Builder.Default
    private final String country = "UK";
    private final OffsetDateTime createdAt;
    private final OffsetDateTime updatedAt;
}
