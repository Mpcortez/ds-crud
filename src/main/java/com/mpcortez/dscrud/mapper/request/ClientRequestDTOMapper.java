package com.mpcortez.dscrud.mapper.request;

import com.mpcortez.dscrud.dto.request.ClientRequestDTO;
import com.mpcortez.dscrud.entities.Client;

public class ClientRequestDTOMapper {

    public static Client mapper(ClientRequestDTO dto) {
        return Client.builder()
                .id(dto.id())
                .name(dto.name())
                .cpf(dto.cpf())
                .income(dto.income())
                .birthDate(dto.birthDate())
                .children(dto.children())
                .build();
    }

    public static Client mapper(Client client, ClientRequestDTO dto) {
        client.setName(dto.name());
        client.setCpf(dto.cpf());
        client.setIncome(dto.income());
        client.setBirthDate(dto.birthDate());
        client.setChildren(dto.children());
        return client;
    }
}
