package br.com.zup.pix

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.Valid

@Validated
@Controller("/pix")
class ChavePixController(private val chavePixRepository: ChavePixRepository) {

    @Post
    @Transactional
    fun cadastraChave(@Body @Valid request: NovaChavePixRequest): HttpResponse<Any> {

        val novaChavePix = request.paraChaveId()
        val chavePix =  chavePixRepository.save(novaChavePix)

        println("Chave Pix criada com sucesso nº => ${chavePix.chaveId}")

        val pix = HttpResponse.uri("${chavePix.chaveId}")

        return HttpResponse.created(pix)
    }
}


//@Post
//fun cadastraChave(@Body @Valid request: NovaChavePixRequest) : HttpResponse<Any> {
//    val contaAssociadaResponse = buscaContaCliente.consulta(request.chaveId)
//
//    val chavePix = request.paraChaveId(contaAssociadaResponse.body()!!)
//    chavePixRepository.save(chavePix)
//
//    println("Chave Pix criada com sucesso nº => ${chavePix.chaveId}")
//
//    val uri = UriBuilder.of("/pix/{id}")
//        .expand(mutableMapOf(Pair("id", chavePix.id)))
//
//    return HttpResponse.created(uri)
//}