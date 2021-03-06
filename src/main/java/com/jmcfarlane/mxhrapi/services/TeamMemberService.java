package com.jmcfarlane.mxhrapi.services;

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

    public void updateManager(TeamMember teamMember, String managerId){
        managerRepository.findById(managerId)
                .ifPresent(employee -> {
                    employee.addTeamMember(teamMember);
                    managerRepository.save(employee);
                });
    }
}
