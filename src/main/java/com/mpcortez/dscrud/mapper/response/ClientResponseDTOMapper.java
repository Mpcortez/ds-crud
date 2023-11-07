package com.mpcortez.dscrud.mapper.response;

import com.mpcortez.dscrud.dto.response.ClientResponseDTO;
import com.mpcortez.dscrud.entities.Client;

public class ClientResponseDTOMapper {

    public static ClientResponseDTO mapper(Client client) {
        return new ClientResponseDTO(
                client.getId(),
                client.getName(),
                client.getCpf(),
                client.getIncome(),
                client.getBirthDate(),
                client.getChildren()
        );
    }
}
