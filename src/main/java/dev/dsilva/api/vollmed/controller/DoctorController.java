package dev.dsilva.api.vollmed.controller;

import dev.dsilva.api.vollmed.doctors.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
    private final static int PAGINATION_SIZE = 10;
    private final static String SORT_PROPERTY = "name";

    @Autowired
    private DoctorRepository repository;

    @PostMapping
    @Transactional
    public void save(@RequestBody @Valid CreateDoctorRequest createDoctorRequest) {
        repository.save(new Doctor(createDoctorRequest));
    }

    @GetMapping
    public ResponseEntity<Page<DoctorResponse>> list(@PageableDefault(size = PAGINATION_SIZE, sort = {SORT_PROPERTY}) Pageable pagination) {
        var page = repository.findAll(pagination).map(DoctorResponse::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DoctorData> findById(@PathVariable Long id) {
        var doctorData = repository.findById(id)
                .map(DoctorData::new)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Doctor with id %d not found", id)));

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
