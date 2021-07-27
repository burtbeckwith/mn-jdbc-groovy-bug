package example.micronaut.chess.repository

import example.micronaut.chess.entity.GameState
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Join
import io.micronaut.data.annotation.Repository
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotNull

import static io.micronaut.data.annotation.Join.Type.FETCH

// WORKS

//interface GameStateRepository {}

// FAILS

@Repository
interface GameStateRepository extends CrudRepository<GameState, UUID> {

    @Override
    @NonNull
    @Join(value = "game", type = FETCH)
    Optional<GameState> findById(@NotNull @NonNull UUID id)
}
