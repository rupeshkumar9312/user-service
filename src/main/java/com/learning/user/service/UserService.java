package com.learning.user.service;

import com.learning.user.VO.Department;
import com.learning.user.VO.ResponseTemplate;
import com.learning.user.entity.User;
import com.learning.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user){
        log.info("Inside saveUser of UserService");
        return userRepository.save(user);
    }

    public ResponseTemplate findUserById(Long userId){
        log.info("Inside findUserById of UserService");
        User user = userRepository.findById(userId).orElseThrow();
        ResponseTemplate ro = new ResponseTemplate();
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);

        ro.setUser(user);
        ro.setDepartment(department);

        return ro;
    }
}
