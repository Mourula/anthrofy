package com.justai.jaicf.template.scenario

import com.justai.jaicf.channel.googleactions.dialogflow.DialogflowIntent
import com.justai.jaicf.model.scenario.Scenario

object MainScenario : Scenario() {

    init {
        state("welcome") {
            activators {
                intent(DialogflowIntent.WELCOME)
            }

            action {
                reactions.sayRandom(
                    "Hey you!"
                )
            }
        }

        state("hello") {
            activators {
                intent("Hello robot")
            }

            action {
                reactions.sayRandom(
                    "Hello! How are you?",
                    "Hi there! What's up?",
                    "What do you want?"
                )
            }
        }

        state("bye") {
            activators {
                intent("Bye")
            }

            action {
                reactions.sayRandom(
                    "Talk to you soon!",
                    "Bye-bye!",
                    "What a boring human!"
                )
            }
        }

        fallback {
            reactions.sayRandom(
                "Sorry, I didn't get that...",
                "Sorry, could you repeat please?",
                "Why are you mumbling?"
            )
        }
    }
}