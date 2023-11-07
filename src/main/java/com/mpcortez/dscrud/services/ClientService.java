package com.mpcortez.dscrud.services;

import com.mpcortez.dscrud.dto.request.ClientRequestDTO;
import com.mpcortez.dscrud.entities.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

public interface ClientService {

    @Transactional(readOnly = true)
    Client findById(Long id);

    @Transactional(readOnly = true)
    Page<Client> findAll(Pageable pageable);

    @Transactional
    Client insert(ClientRequestDTO requestDTO);

    @Transactional
    Client update(Long id, ClientRequestDTO requestDTO);

    @Transactional
    void delete(Long id);
}
