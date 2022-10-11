package com.example.registrationlogin;

import com.example.registrationlogin.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Long> {}
