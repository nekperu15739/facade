# Facade

## Immutability:
In the following example we will see how to use Immutability.

### Using lombok:

```java
@Getter
@Builder
@Jacksonized
public class InmutableLombokResource {

    private final UUID id;

    @Builder.Default
    private final String country = "UK";
    private final OffsetDateTime updatedAt;
}
```

### Using records:

```java
@Builder
public record RecordResource(
    UUID id,
    OffsetDateTime updatedAt) {

    public RecordResource {
        country = ofNullable(country)
            .orElse("UK");
    }

}

```


By **default**, Spring Boot configures Jackson's to use **UTC** timezone instead of the local system timezone for a few important reasons: `ObjectMapper`
1. **Consistency**: UTC provides a standard reference point that's independent of local time zones, making it easier to handle data across different regions.
2. **Avoiding Ambiguity**: Using local time zones can lead to ambiguity, especially during daylight savings transitions where the same time can occur twice or be skipped entirely.
3. **Database Compatibility**: Many databases store timestamps in UTC internally, so using UTC in the application layer aligns well with database practices.
4. **Distributed Systems**: When your application runs across multiple servers in different time zones, using UTC ensures consistent timestamp handling.

If you want to use the local timezone instead, you can change this behavior by setting:

```yaml
spring.jackson.time-zone=${user.timezone}
```
