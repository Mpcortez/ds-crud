package com.mpcortez.dscrud.services.impl;

import com.mpcortez.dscrud.dto.request.ClientRequestDTO;
import com.mpcortez.dscrud.entities.Client;
import com.mpcortez.dscrud.mapper.request.ClientRequestDTOMapper;
import com.mpcortez.dscrud.repositories.ClientRepository;
import com.mpcortez.dscrud.services.ClientService;
import com.mpcortez.dscrud.services.exception.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {

    private static final String CLIENT_NOT_FOUND_MSG = "Cliente não encontrado.";

    private final ClientRepository repository;

    @Override
    public Client findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CLIENT_NOT_FOUND_MSG));
    }

    @Override
    public Page<Client> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @Override
    public Client insert(ClientRequestDTO requestDTO) {
        return repository.save(ClientRequestDTOMapper.mapper(requestDTO));
    }

    @Override
    public Client update(Long id, ClientRequestDTO requestDTO) {
        try {
            var client = repository.getReferenceById(id);
            return repository.save(ClientRequestDTOMapper.mapper(client, requestDTO));
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(CLIENT_NOT_FOUND_MSG);
        }
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) throw new ResourceNotFoundException(CLIENT_NOT_FOUND_MSG);

        repository.deleteById(id);
    }
}
