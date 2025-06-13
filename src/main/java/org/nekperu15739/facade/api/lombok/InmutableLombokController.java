package org.nekperu15739.facade.api.lombok;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@RestController
@RequestMapping("/lombok")
@RequiredArgsConstructor
public class InmutableLombokController {

    @PostMapping
    public ResponseEntity<InmutableLombokResource> addNewUser(@RequestBody final InmutableLombokResource resource) {
        return ok()
            .body(resource);
    }
}
