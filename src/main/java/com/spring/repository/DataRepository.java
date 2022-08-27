package com.spring.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Data;

@Repository
public interface DataRepository extends JpaRepository<Data, Integer> {

	public Set<Data> findByCategoryCategoryId(int categoryId);
}
