package day2

import util.splitOn

fun parse(line: String): Game =
    line.splitOn(":")
        .let { (game, sets) ->
            Game(
                game.splitOn(" ").second.toInt(),
                sets.split(";")
                    .map { set ->
                        set
                            .split(",").associate { cube ->
                                cube.trim().splitOn(" ").let { (number, color) ->
                                    Game.Color.valueOf(color.uppercase()) to number.toInt()
                                }
                            }
                    }
                    .map {
                        Colors(
                            red = it.getOrDefault(Game.Color.RED, 0),
                            green = it.getOrDefault(Game.Color.GREEN, 0),
                            blue = it.getOrDefault(Game.Color.BLUE, 0),
                        )
                    },
            )
        }
