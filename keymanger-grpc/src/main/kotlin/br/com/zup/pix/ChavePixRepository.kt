package br.com.zup.pix

import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

interface ChavePixRepository : JpaRepository<ChavePix, Long>{

    fun existsByChaveId(chaveId: UUID): Boolean
}