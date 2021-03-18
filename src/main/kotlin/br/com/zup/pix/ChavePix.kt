package br.com.zup.pix

import org.hibernate.annotations.Table
import org.hibernate.validator.constraints.br.CPF
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity
@Table(appliesTo = "chave_pix")
data class ChavePix(

    @field:NotNull
    var chaveId: UUID?,

    @field:NotNull
    @Column(nullable = false)
    var tipo: TipoChave?,

    @field:NotNull
    @Column(nullable = false)
    @CPF
    var tipoConta: TipoConta?,

    @Embedded
    var conta: ContaAssociada?
) {
    @Id
    val id: Long? = null

    @Column(nullable = false)
    val criadaEm: LocalDateTime = LocalDateTime.now()
}