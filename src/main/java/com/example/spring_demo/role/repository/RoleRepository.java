package com.example.spring_demo.role.repository;

import com.example.spring_demo.role.model.Role;
import com.example.spring_demo.role.model.RoleType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    // I priority
    //    Optional<Role> findFirstByRoleType(RoleType roleType);

    // II priority
    @Query("SELECT r FROM roles r WHERE r.roleType = :roleType")
    Optional<Role> findFirstByRoleTypeJPQL(@Param("roleType") RoleType roleType);

    // III priority
    //      role_type, count
    //      ADMIN   1
    //      USER    5
    @Query(value = "SELECT r.role_type, count(*) " +
            "FROM roles r JOIN users_roles ur ON r.role_id = ur.roles_role_id " +
            "GROUP BY r.role_type " +
            "ORDER BY 2 DESC",
            nativeQuery = true)
    List<Object[]> groupRolesByNameNativeSQL();


}
