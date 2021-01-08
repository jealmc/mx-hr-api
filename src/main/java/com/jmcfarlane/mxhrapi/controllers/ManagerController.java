package com.jmcfarlane.mxhrapi.controllers;

import com.jmcfarlane.mxhrapi.GenericNotFoundException;
import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ManagerController {
    private ManagerRepository repository;

    @Autowired
    public ManagerController(ManagerRepository repository){
        this.repository = repository;
    }

    @GetMapping("/managers")
    Set<Manager> all() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @GetMapping("/manager/{id}")
    Manager getByID(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException("Manager"));
    }

    @PutMapping("/manager/{id}")
    Manager updateByID(@PathVariable String id, @RequestBody Manager Manager) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(Manager.getFirstName());
                    employee.setLastName(Manager.getLastName());
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    Manager.setId(id);
                    return repository.save(Manager);
                });
    }


    @DeleteMapping("/manager/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PostMapping("/manager")
    Manager createNew(@RequestBody Manager Manager) {
        return repository.save(Manager);
    }
}
