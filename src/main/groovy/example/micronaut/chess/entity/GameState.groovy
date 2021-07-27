package example.micronaut.chess.entity

import groovy.transform.CompileStatic
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import io.micronaut.data.annotation.Relation

import static io.micronaut.data.annotation.Relation.Kind.MANY_TO_ONE

@MappedEntity('GAME_STATE')
@CompileStatic
class GameState {

    @Id
    final UUID id

    @Relation(MANY_TO_ONE)
    final Game game

    GameState(UUID id, Game game) {
        this.id = id;
        this.game = game
    }
}
