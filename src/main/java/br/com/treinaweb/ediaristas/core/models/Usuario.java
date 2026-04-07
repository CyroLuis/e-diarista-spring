package br.com.treinaweb.ediaristas.core.models;

import br.com.treinaweb.ediaristas.core.enums.TipoUsuario;
import lombok.*;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString(onlyExplicitlyIncluded = true)
public class Usuario {

    @EqualsAndHashCode.Include
    @ToString.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "nome_completo", nullable = false)
    private String nomeCompleto;

    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(name = "tipo_usuario", length = 8, nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}
