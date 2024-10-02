package dev.dsilva.api.vollmed.controller;

import dev.dsilva.api.vollmed.doctors.*;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
    public void save(@RequestBody @Valid CreateDoctor createDoctor) {
        repository.save(new Doctor(createDoctor));
    }

    @GetMapping
    public Page<GetDoctor> list(@PageableDefault(size = PAGINATION_SIZE, sort = {SORT_PROPERTY}) Pageable pagination) {
        return repository.findAll(pagination).map(GetDoctor::new);
    }

    @GetMapping("/{id}")
    public DoctorData findById(@PathVariable Long id) {
        return repository.findById(id)
                .map(DoctorData::new)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Doctor with id %d not found", id)));
    }

    @PutMapping("/{id}")
    @Transactional
    public void update(@RequestBody @Valid UpdateDoctorRequest requestBody) {
        var doctor = repository.getReferenceById(requestBody.id());

        doctor.update(requestBody);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public void remove(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        medico.remove();
    }
}
