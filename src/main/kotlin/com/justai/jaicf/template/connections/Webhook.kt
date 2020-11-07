package com.justai.jaicf.template.connections

import com.justai.jaicf.channel.googleactions.ActionsFulfillment
import com.justai.jaicf.channel.http.httpBotRouting
import com.justai.jaicf.template.templateBot
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

fun main() {
    embeddedServer(Netty, 8001) {
        routing {
            httpBotRouting(
                "/" to ActionsFulfillment.dialogflow(templateBot)
            )
        }
    }.start(wait = true)
}
