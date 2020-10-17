package com.pe.web.function.app.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pe.web.function.app.entity.Function;

@Repository
@Transactional
public interface FunctionRepository extends JpaRepository<Function,Integer>{

}
