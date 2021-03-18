package br.com.zup.pix

data class ContaAssociadaResponse(
    val instituicao: String,
    val titular: String,
    val cpf: String,
    val agencia: String,
    val conta: String,
)