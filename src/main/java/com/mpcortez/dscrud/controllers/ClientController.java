package com.mpcortez.dscrud.controllers;

import com.mpcortez.dscrud.dto.request.ClientRequestDTO;
import com.mpcortez.dscrud.dto.response.ClientResponseDTO;
import com.mpcortez.dscrud.mapper.response.ClientResponseDTOMapper;
import com.mpcortez.dscrud.services.ClientService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NO_CONTENT;

@RestController
@RequiredArgsConstructor
@RequestMapping("clients")
public class ClientController {

    private final ClientService service;

    @GetMapping(value = "{id}")
    public ClientResponseDTO findById(@PathVariable Long id) {
        return ClientResponseDTOMapper.mapper(service.findById(id));
    }

    @GetMapping()
    public Page<ClientResponseDTO> findAll(Pageable pageable) {
        return service.findAll(pageable).map(ClientResponseDTOMapper::mapper);
    }

    @PostMapping()
    @ResponseStatus(CREATED)
    public ResponseEntity<ClientResponseDTO> insert(@RequestBody @Valid ClientRequestDTO dto) {
        var responseDTO = ClientResponseDTOMapper.mapper(service.insert((dto)));
        var uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}")
                .buildAndExpand(responseDTO.id()).toUri();
        return ResponseEntity.created(uri).body(responseDTO);
    }

    @PutMapping(value = "{id}")
    public ClientResponseDTO update(@PathVariable Long id, @RequestBody @Valid ClientRequestDTO dto) {
        return ClientResponseDTOMapper.mapper(service.update(id, dto));
    }

    @DeleteMapping(value = "{id}")
    @ResponseStatus(NO_CONTENT)
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
