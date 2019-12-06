package com.project.toDoList.mapper;

public interface CustomMapper<Modeli,ObjektiDto>{

    ObjektiDto mapToDto(Modeli entity);
    Modeli mapToEntity(ObjektiDto dto);
}
