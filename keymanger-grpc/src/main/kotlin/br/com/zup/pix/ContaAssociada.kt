package br.com.zup.pix

import io.micronaut.core.annotation.Introspected
import org.hibernate.validator.constraints.br.CPF
import javax.persistence.Embeddable
import javax.validation.constraints.NotBlank

@Introspected
@Embeddable
class ContaAssociada(
    @field:NotBlank
    val instituicao: String,

    @field:NotBlank
    val titular: String,

    @field:NotBlank
    @CPF
    val cpf: String,

    @field:NotBlank
    val agencia: String,

    @field:NotBlank
    val conta: String
)