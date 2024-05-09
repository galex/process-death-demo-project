package dev.galex.process.death.demo.compose.navigation

import kotlinx.serialization.Serializable


sealed interface NavRoutes {
    @Serializable
    object EnterName

    @Serializable
    object ShowInfo
}