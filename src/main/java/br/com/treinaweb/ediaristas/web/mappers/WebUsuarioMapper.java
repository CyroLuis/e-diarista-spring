package br.com.treinaweb.ediaristas.web.mappers;

import br.com.treinaweb.ediaristas.core.models.Usuario;
import br.com.treinaweb.ediaristas.web.dtos.UsuarioDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface WebUsuarioMapper {
    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    Usuario toModel(UsuarioDto usuarioDto);
}
