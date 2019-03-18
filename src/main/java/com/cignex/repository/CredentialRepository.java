package com.cignex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cignex.model.Credential;
@Repository("credentialRepository")
public interface CredentialRepository extends JpaRepository<Credential, Integer> {

}
