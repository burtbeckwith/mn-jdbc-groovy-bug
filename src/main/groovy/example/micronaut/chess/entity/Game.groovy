package example.micronaut.chess.entity

import groovy.transform.CompileStatic
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity

@MappedEntity('GAME')
@CompileStatic
class Game {

    @Id
    final UUID id

    Game(UUID id) {
        this.id = id
    }
}
