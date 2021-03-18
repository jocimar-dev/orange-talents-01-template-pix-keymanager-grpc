package br.com.zup.pix

import javax.persistence.Embeddable

@Embeddable
data class ContaAssociada(
    val instituicao: String,
    val titular: String,
    val cpf: String,
    val agencia: String,
    val conta: String,
) {

}

