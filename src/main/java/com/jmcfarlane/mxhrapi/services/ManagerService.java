package com.jmcfarlane.mxhrapi.services;

import com.jmcfarlane.mxhrapi.pojos.TeamMember;
import com.jmcfarlane.mxhrapi.repos.ManagerRepository;
import com.jmcfarlane.mxhrapi.repos.TeamMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class ManagerService {
    TeamMemberRepository repository;
    ManagerRepository managerRepository;

    @Autowired
    public ManagerService(TeamMemberRepository repository, ManagerRepository managerRepository){
        this.repository = repository;
        this.managerRepository = managerRepository;
    }

    public Set<TeamMember> updateTeamMembers(String managerId){
        if(managerId == null || managerId.isEmpty())
            return new HashSet<>();
        return repository.findByManagerId(managerId);
    }
}
