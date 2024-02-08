package com.example.assesment2.mapper;

import com.example.assesment2.dto.CatalogDto;
import com.example.assesment2.dto.UserDto;
import com.example.assesment2.entity.Catalog;
import com.example.assesment2.entity.Users;

public class Mapper {
    public static UserDto convertToUserDto(Users users){
        return new UserDto(users.getUserId(),users.getUsername());
    }


    public static CatalogDto convertToProduct(Catalog catalog){
        return new CatalogDto(catalog.getCatalogId(),catalog.getName());
    }

}
