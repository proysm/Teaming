package com.example.demo;

import com.example.demo.repository.*;
import com.example.demo.response.ResponseService;
import com.example.demo.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@Configuration

@EnableJpaRepositories("com.example.demo.repository")
@EnableTransactionManagement
public class SpringConfig {

    @PersistenceContext
    EntityManager em;

    @PersistenceUnit
    EntityManagerFactory emf;

    public SpringConfig(EntityManager em){
        this.em = em;
    }

    @Autowired
    public UserRepository userRepository(){
        return new UserRepositoryImpl(em);
    }

    @Autowired
    public ProjectRepository projectRepository(){
        return new ProjectRepositoryImpl(em);
    }

    @Autowired
    public ProjectLikeRepository projectLikeRepository(){
        return new ProjectLikeRepositoryImpl(em);
    }

    @Autowired
    public ApplyRepository applyRepository(){
        return new ApplyRepositoryImpl(em);
    }

    @Autowired
    public InvitationRepository invitationRepository(){
        return new InvitationRepositoryImpl(em);
    }

    @Autowired
    public ProjectMemberRepository memberRepository(){
        return new ProjectMemberRepositoryImpl(em);
    }

    @Autowired
    public ResponseRepository responseRepository(){
        return new ResponseRepositoryImpl(em);
    }


    @Bean
    public ProjectService projectService(){
        return new ProjectService(projectRepository());
    }

    @Bean
    public ApplyService applyService(){
        return new ApplyService(applyRepository());
    }

    @Bean
    public InvitationService invitationService(){
        return new InvitationService(invitationRepository());
    }

    @Bean
    public ProjectMemberService memberService(){
        return new ProjectMemberService(memberRepository());
    }

    @Bean
    public ResponseService responseService(){
        return new ResponseService(responseRepository());
    }

}

