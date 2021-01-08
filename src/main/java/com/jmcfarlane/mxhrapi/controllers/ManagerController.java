package com.jmcfarlane.mxhrapi.controllers;

import com.jmcfarlane.mxhrapi.pojos.Employee;
import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.repos.EmployeeRepository;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
public class ManagerController {
    @Autowired
    ManagerRepository managerRepository;

    @GetMapping("/managers")
    Set<Manager> all() {
        return StreamSupport
                .stream(managerRepository.findAll().spliterator(), false)
                .collect(Collectors.toSet());
    }

    @PostMapping("/manager")
    Manager createNew(@RequestBody Manager manager) {
        return managerRepository.save(manager);
    }
}
