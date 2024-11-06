package com.example.bookingticket.Service.Mappers;

import com.example.bookingticket.model.dtos.UserAccount.CreateUseAccountDTO;
import com.example.bookingticket.model.entities.Role;
import com.example.bookingticket.model.entities.UserAccountEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserAccountMapper {
    UserAccountMapper INSTANCE = Mappers.getMapper(UserAccountMapper.class);

    @Mapping(source = "role", target = "role")
    UserAccountEntity toEntity(CreateUseAccountDTO dto);

    default Role mapRole(String role) {
        try {
            return Role.valueOf(role); // Chuyển chuỗi thành enum
        } catch (IllegalArgumentException e) {
            // Xử lý lỗi khi chuỗi không phải là một giá trị hợp lệ của enum
            throw new IllegalArgumentException("Invalid role: " + role);
        }
    }
}