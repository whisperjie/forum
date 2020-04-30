package com.whisper.forum.dao;

import com.whisper.forum.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends JpaSpecificationExecutor<User>,JpaRepository<User, Integer> {
    /*
    通过邮箱和用户名查询
     */
    User findByEmail(String email);

    List<User> findByNameLike(String name);
    //User findById(Integer id);

}
