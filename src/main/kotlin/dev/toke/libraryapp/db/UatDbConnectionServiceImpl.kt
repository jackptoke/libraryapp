package dev.toke.libraryapp.db

import org.springframework.context.annotation.Profile
import org.springframework.stereotype.Service

@Service("DbConnectionService")
@Profile("UAT")
class UatDbConnectionServiceImpl : DbConnectionService {
    override fun getConnectionString(): String {
        return "uat:db:connection-string"
    }
}