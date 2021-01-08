package com.jmcfarlane.mxhrapi.controllers;

import com.jmcfarlane.mxhrapi.GenericNotFoundException;
import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.pojos.TeamMember;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import com.jmcfarlane.mxhrapi.services.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ManagerController {
    private ManagerRepository repository;
    private ManagerService service;

    @Autowired
    public ManagerController(ManagerRepository repository, ManagerService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/managers")
    Set<Manager> all() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), false)
                .map(manager -> {
                            manager.setTeamMembers(service.updateTeamMembers(manager.getId()));
                            return manager;
                        }
                ).collect(Collectors.toSet());
    }

    @GetMapping("/manager/{id}")
    Manager getByID(@PathVariable String id) {
        Manager manager = repository.findById(id).orElseThrow(() -> new GenericNotFoundException("Manager"));
        Set<TeamMember> teamMembers = service.updateTeamMembers(manager.getId());
        manager.setTeamMembers(teamMembers);
        return manager;
    }

    @PutMapping("/manager/{id}")
    Manager updateByID(@PathVariable String id, @RequestBody Manager manager) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(manager.getFirstName());
                    employee.setLastName(manager.getLastName());
                    employee.setTeamMembers(service.updateTeamMembers(id));
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    manager.setId(id);
                    return repository.save(manager);
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
