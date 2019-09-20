package com.rm.SpringbootRest.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rm.SpringbootRest.model.DBFile;
@Repository
public interface DBFileRepository extends JpaRepository<DBFile, String> {

}
