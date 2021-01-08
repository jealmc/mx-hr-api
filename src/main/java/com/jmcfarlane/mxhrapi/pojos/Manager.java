package com.jmcfarlane.mxhrapi.pojos;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@RedisHash("Managers")
public class Manager extends Employee implements Serializable {
    public Set<TeamMember> teamMembers = new HashSet<>();

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }

    public void setTeamMembers(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public void addTeamMember(TeamMember teamMember){
        this.teamMembers.add(teamMember);
    }

}
