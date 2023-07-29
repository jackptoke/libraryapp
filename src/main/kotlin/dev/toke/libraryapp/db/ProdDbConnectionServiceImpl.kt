package dev.toke.libraryapp.db

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("DbConnectionService")
@Profile("PROD")
class ProdDbConnectionServiceImpl : DbConnectionService {
    override fun getConnectionString(): String {
        return "production:db:connection-string"
    }
}