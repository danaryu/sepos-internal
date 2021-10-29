package com.sinc.sepos.internal.mapper.dtomapper;

import com.sinc.sepos.internal.dto.StoreDTO;
import com.sinc.sepos.internal.entity.Store;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface StoreDTOMapper {
    StoreDTOMapper INSTANCE = Mappers.getMapper(StoreDTOMapper.class);
    StoreDTO toDTO(Store store);
}
