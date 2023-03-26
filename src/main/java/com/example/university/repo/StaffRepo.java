package com.example.university.repo;

import com.example.university.domain.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "staff" , collectionResourceRel = "staff")
public interface StaffRepo extends JpaRepository<Staff , Integer> {
    @Query("SELECT s FROM Staff s where s.member.lastName = :lastName")
    Optional<Staff> findByLastName(@Param("lastName") String lastName);
}
