package me.tmarciniak.axon.observability.observation

object ContextualNameConverter {
    fun camelAndDotToSpaceSeparated(input: String): String {
        return input.replace(Regex("([a-z])([A-Z])"), "$1 $2")
            .replace(Regex("\\."), " ")
            .lowercase()
    }
}