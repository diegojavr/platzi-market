package com.platzi.market.persistance.mapper;

import com.platzi.market.domain.Category;
import com.platzi.market.persistance.entities.Categoria;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mappings({
            @Mapping(source = "idCategoria", target = "categoryId"),
            @Mapping(source = "descripcion", target = "category"),
            @Mapping(source = "estado", target = "active")
    })
    Category toCategory(Categoria category);

    @InheritInverseConfiguration //Indica que la conversión es inversa a la anterior
    @Mapping(target = "productos", ignore = true)
        //Ignoramos el que no queremos que convierta
    Categoria toCategoria(Category category);
}
