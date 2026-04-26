package br.com.treinaweb.ediaristas.web.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioDto {
    @NotNull
    @Size(min= 3,max = 255)
    private String nomeCompleto;

    @NotNull
    @Email
    @Size(min = 3,max = 255)
    private String email;

    @NotNull
    @NotEmpty
    private String senha;

    @NotNull
    @NotEmpty
    private String confirmacaoSenha;
}
