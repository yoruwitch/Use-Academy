package com.example.corroutine

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepository {

    val listZeldaGames = listOf<String>(
        "The Legend of Zelda",
        "The Legend of Zelda II: The Adventure of Link",
        "The Legend of Zelda: A Link to the Past",
        "The Legend of Zelda: Link's Awakening",
        "The Legend of Zelda: Ocarina of Time",
        "The Legend of Zelda: Majora's Mask",
        "The Legend of Zelda: Oracle of Seasons and Ages",
        "The Legend of Zelda: Four Swords",
        "The Legend of Zelda: The Wind Waker",
        "The Legend of Zelda: Four Swords Adventures",
        "The Legend of Zelda: The Minish Cap",
        "The Legend of Zelda: Twilight Princess",
        "The Legend of Zelda: Phantom Hourglass",
        "The Legend of Zelda: Spirit Tracks",
        "The Legend of Zelda: Skywardd Sword",
        "The Legend of Zelda: A Link Between Worlds",
        "The Legend of Zelda: Tri Force Heroes",
        "Hyrule Warriors",
        "Hyrule Warriors: Age of Calamity",
        "The Legend of Zelda: Breath of the Wild"

    )

    suspend fun getData(): Flow<String> {
        return flow {
            listZeldaGames.forEach { game ->
                emit(game)
                delay(2000)
            }
        }
    }
}