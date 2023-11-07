package com.mpcortez.dscrud.repositories;

import com.mpcortez.dscrud.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
