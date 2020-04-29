package com.whisper.forum.dao;

import com.whisper.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDao extends JpaSpecificationExecutor<User>,JpaRepository<User, Integer> {
    /*
    通过邮箱和用户名查询
     */
    //User findByEmail(String email);

    User findByEmail(String email);
    //User findById(Integer id);

}
