package com.justai.jaicf.template.connections

import com.justai.jaicf.channel.googleactions.jaicp.ActionsFulfillmentDialogflow
import com.justai.jaicf.channel.jaicp.JaicpPollingConnector
import com.justai.jaicf.activator.caila.CailaNLUSettings
import java.util.*

import com.justai.jaicf.template.templateBot

fun main() {
    val accessToken: String = System.getenv("JAICP_API_TOKEN") ?: Properties().run {
        load(CailaNLUSettings::class.java.getResourceAsStream("/jaicp.properties"))
        getProperty("apiToken")
    }
    
    JaicpPollingConnector(
        templateBot,
        accessToken,
        channels = listOf(                
            ActionsFulfillmentDialogflow
        )
    ).runBlocking()
}
