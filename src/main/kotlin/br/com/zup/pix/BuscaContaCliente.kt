package br.com.zup.pix

import io.micronaut.http.HttpResponse
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Consumes
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client
import java.util.*

@Client("http://localhost:9091")
interface BuscaContaCliente {

    @Get
    @Consumes(MediaType.APPLICATION_XML)
    fun consulta(@QueryValue cep: UUID) : HttpResponse<ContaAssociadaResponse>

}
