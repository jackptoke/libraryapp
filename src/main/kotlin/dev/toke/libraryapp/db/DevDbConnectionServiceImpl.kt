package dev.toke.libraryapp.db

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("DbConnectionService")
@Profile("DEV", "default")
class DevDbConnectionServiceImpl : DbConnectionService {
    override fun getConnectionString(): String {
        return "development:db:connection-string"
    }
}