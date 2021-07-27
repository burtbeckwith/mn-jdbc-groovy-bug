package example.micronaut.chess.repository

import example.micronaut.chess.entity.GameState
import io.micronaut.context.annotation.Primary
import io.micronaut.core.annotation.NonNull
import io.micronaut.data.annotation.Join
import io.micronaut.data.jdbc.annotation.JdbcRepository
import io.micronaut.data.repository.CrudRepository

import javax.validation.constraints.NotNull

import static io.micronaut.data.annotation.Join.Type.FETCH
import static io.micronaut.data.model.query.builder.sql.Dialect.H2

// WORKS

//@JdbcRepository(dialect = H2)
//interface H2GameStateRepository extends CrudRepository<GameState, UUID> {
//
//    @Override
//    @NonNull
//    @Join(value = "game", type = FETCH)
//    Optional<GameState> findById(@NotNull @NonNull UUID id)
//}

// FAILS

@Primary
@JdbcRepository(dialect = H2)
interface H2GameStateRepository extends GameStateRepository {
}
