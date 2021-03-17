package br.com.zup.pix

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Post
import io.micronaut.http.client.annotation.Client
import java.time.LocalDateTime

@Client("\${bcb.pix.url}")
interface BancoCentralClient {
    @Post("/api/v1/pix/keys", produces = [MediaType.APPLICATION_XML], consumes = [MediaType.APPLICATION_XML])
    fun create(@Body request: CreatePixKeyRequest): HttpResponse<CreatePixKeyResponse>
}

    data class CreatePixKeyRequest(
        val tipoChave: TipoChave,
        val tipoConta: TipoConta,
        val contaAssociada: ContaAssociada,
        val clientId: ChavePix
    )

    data class CreatePixKeyResponse (
        val tipoChave: TipoChave,
        val tipoConta: TipoConta,
        val contaAssociada: ContaAssociada,
        val clientId: ChavePix,
        val createdAt: LocalDateTime
    )