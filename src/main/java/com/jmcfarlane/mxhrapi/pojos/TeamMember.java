package com.jmcfarlane.mxhrapi.pojos;

import org.springframework.data.redis.core.RedisHash;

import java.io.Serializable;

@RedisHash("TeamMembers")
public class TeamMember extends Employee implements Serializable {
    public Manager manager;
}
