package example.micronaut

import example.micronaut.chess.entity.Game
import example.micronaut.chess.entity.GameState
import example.micronaut.chess.repository.GameRepository
import example.micronaut.chess.repository.H2GameStateRepository
import io.micronaut.test.extensions.spock.annotation.MicronautTest
import spock.lang.Specification

import javax.inject.Inject

@MicronautTest
class GameServiceSpec extends Specification {

    @Inject
    GameRepository gameRepository

    @Inject
    H2GameStateRepository gameStateRepository

    void test() {
        when:
        UUID gameId = UUID.randomUUID()
        gameRepository.save new Game(gameId)
        Game game = gameRepository.findById(gameId).orElse(null)

        then:
        game
        gameId == game.id

        when:
        UUID gameStateId = UUID.randomUUID()
        gameStateRepository.save new GameState(gameStateId, game)
        GameState gameState = gameStateRepository.findById(gameStateId).orElse(null)

        then:
        gameState
        gameStateId == gameState.id
    }

    void cleanup() {
        gameStateRepository.deleteAll()
        gameRepository.deleteAll()
    }
}
