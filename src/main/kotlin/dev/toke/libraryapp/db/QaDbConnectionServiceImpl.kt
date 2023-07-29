package dev.toke.libraryapp.db

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("DbConnectionService")
@Profile("QA")
class QaDbConnectionServiceImpl : DbConnectionService {
    override fun getConnectionString(): String {
        return "quality:db:connection-string"
    }
}