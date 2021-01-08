package com.jmcfarlane.mxhrapi.controllers;

import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.repos.EmployeeRepository;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import com.jmcfarlane.mxhrapi.repos.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class TeamMemberController {
    TeamMemberRepository repository;

    @Autowired
    public TeamMemberController(TeamMemberRepository repository){
        this.repository = repository;
    }

    @PostMapping("/team-member")
    Manager createNew(@RequestBody Manager manager) {
        return repository.save(manager);
    }
}
