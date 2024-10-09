package dev.dsilva.api.vollmed.controller;

import dev.dsilva.api.vollmed.doctors.*;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final static String SORT_PROPERTY = "name";

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<UpdateDoctorResponse> save(@RequestBody @Valid CreateDoctorRequest createDoctorRequest,
                                                     UriComponentsBuilder builder) {
        var doctor = new Doctor(createDoctorRequest);
        repository.save(doctor);

        var uri = builder
                .path(("/doctors/{id}"))
                .buildAndExpand(doctor.getId())
                .toUri();

        return ResponseEntity.created(uri).body(new UpdateDoctorResponse(doctor));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorResponse>> list(@PageableDefault(sort = SORT_PROPERTY) Pageable pagination) {
        var page = repository.findAll(pagination).map(DoctorResponse::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<DoctorData>> findById(@PathVariable Long id) {
        var doctorData = repository.findById(id)
                .map(DoctorData::new);

        if (doctorData.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(doctorData);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<UpdateDoctorResponse> update(@RequestBody @Valid UpdateDoctorRequest updateDoctorRequest) {
        var doctor = repository.getReferenceById(updateDoctorRequest.id());

        doctor.update(updateDoctorRequest);

        return ResponseEntity.ok().body(new UpdateDoctorResponse(doctor));
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> remove(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        medico.remove();

        return ResponseEntity.noContent().build();
    }
}
