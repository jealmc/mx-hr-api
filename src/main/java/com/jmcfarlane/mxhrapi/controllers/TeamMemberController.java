package com.jmcfarlane.mxhrapi.controllers;

import com.jmcfarlane.mxhrapi.GenericNotFoundException;
import com.jmcfarlane.mxhrapi.pojos.TeamMember;
import com.jmcfarlane.mxhrapi.repos.TeamMemberRepository;
import com.jmcfarlane.mxhrapi.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TeamMemberController {
    TeamMemberRepository repository;
    TeamMemberService service;

    @Autowired
    public TeamMemberController(TeamMemberRepository repository, TeamMemberService service){
        this.repository = repository;
        this.service = service;
    }

    @GetMapping("/team-members")
    Set<TeamMember> all() {
        return StreamSupport
                .stream(repository.findAll().spliterator(), true)
                .collect(Collectors.toSet());
    }

    @GetMapping("/team-member/{id}")
    TeamMember getByID(@PathVariable String id) {
        return repository.findById(id).orElseThrow(() -> new GenericNotFoundException("Team Member"));
    }

    @PutMapping("/team-member/{id}")
    TeamMember updateByID(@PathVariable String id, @RequestBody TeamMember teamMember) {
        return repository.findById(id)
                .map(employee -> {
                    employee.setFirstName(teamMember.getFirstName());
                    employee.setLastName(teamMember.getLastName());
                    employee.setManager(service.updateManager(teamMember.getManager()));
                    return repository.save(employee);
                })
                .orElseGet(() -> {
                    teamMember.setId(id);
                    return repository.save(teamMember);
                });
    }


    @DeleteMapping("/team-member/{id}")
    void deleteEmployee(@PathVariable String id) {
        repository.deleteById(id);
    }

    @PostMapping("/team-member")
    TeamMember createNew(@RequestBody TeamMember teamMember) {
        return repository.save(teamMember);
    }
}
