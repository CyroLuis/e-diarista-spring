package br.com.treinaweb.ediaristas.web.mappers;

import br.com.treinaweb.ediaristas.core.models.Servico;
import br.com.treinaweb.ediaristas.web.dtos.ServicoForm;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper(componentModel = "spring")
public interface WebServicoMapper {

    WebUsuarioMapper INSTANCE = Mappers.getMapper(WebUsuarioMapper.class);

    //Converte a camada de dto para a entidade
    Servico toModel(ServicoForm form);

    //Converte a camada de entidade para dto
    ServicoForm toForm(Servico model);
}
