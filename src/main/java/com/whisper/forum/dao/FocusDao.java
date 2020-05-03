package com.whisper.forum.dao;

import com.whisper.forum.entity.Focus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface FocusDao  extends JpaSpecificationExecutor<Focus>, JpaRepository<Focus, Integer> {
}
