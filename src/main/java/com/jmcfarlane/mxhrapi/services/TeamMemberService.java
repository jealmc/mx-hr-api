package com.jmcfarlane.mxhrapi.services;

import com.jmcfarlane.mxhrapi.GenericNotFoundException;
import com.jmcfarlane.mxhrapi.pojos.Manager;
import com.jmcfarlane.mxhrapi.pojos.TeamMember;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import com.jmcfarlane.mxhrapi.repos.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamMemberService {
    TeamMemberRepository repository;
    ManagerRepository managerRepository;

    @Autowired
    public TeamMemberService(TeamMemberRepository repository, ManagerRepository managerRepository){
        this.repository = repository;
        this.managerRepository = managerRepository;
    }

    public Manager updateManager(Manager manager){
        return managerRepository.findById(manager.getId())
                .orElseGet(() -> new Manager());
    }
}
