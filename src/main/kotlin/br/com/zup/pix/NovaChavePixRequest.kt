package br.com.zup.pix

import org.hibernate.annotations.Type
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Embedded
import javax.validation.constraints.NotNull

data class NovaChavePixRequest(
    @field:NotNull
    @Type(type = "org.hibernate.type.UUIDCharType")
    val chaveId: UUID,
    @field:NotNull
    @Column(nullable = false)
    val tipoChave: TipoChave,
    @field:NotNull
    @Column(nullable = false)
    val tipoConta: TipoConta,
    @Embedded
    val conta: ContaAssociada
) {
//    fun paraChaveId(contaAssociadaResponse: ContaAssociadaResponse): ChavePix {
//
//        val contaAssociada = ContaAssociada(contaAssociadaResponse, "Itau",
//        "Zup Academy","216.647.690-21","1234-2","43212-2")
//
//        return ChavePix(chaveId, enumValueOf<TipoChave>(tipoChave.name), enumValueOf<TipoConta>(tipoConta.name), conta)
//    }

    fun paraChaveId(): ChavePix {
        val novaChavePix = NovaChavePixRequest(chaveId, tipoChave, tipoConta, conta)

        return ChavePix(chaveId,tipoChave,tipoConta,conta)
    }

}
//instituicao, titular, cpf, agencia, conta