package br.com.zup.pix

import org.hibernate.annotations.Type
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*
import javax.validation.Valid
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@Entity
class ChavePix(

    @field:NotNull
    @Type(type = "org.hibernate.type.UUIDCharType")
    val chaveId: UUID,

    @field:NotNull
    @Column(nullable = false)
    val tipo: TipoChave,

    @field:NotNull
    @Column(nullable = false)
    val tipoConta: TipoConta,

    @Embedded
    val conta: ContaAssociada
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(nullable = false)
    val criadaEm: LocalDateTime = LocalDateTime.now()
}