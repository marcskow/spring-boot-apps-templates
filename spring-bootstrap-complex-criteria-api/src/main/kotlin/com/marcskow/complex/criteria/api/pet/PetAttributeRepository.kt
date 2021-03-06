package com.marcskow.complex.criteria.api.pet

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface PetAttributeRepository : CrudRepository<PetAttribute, Long>
