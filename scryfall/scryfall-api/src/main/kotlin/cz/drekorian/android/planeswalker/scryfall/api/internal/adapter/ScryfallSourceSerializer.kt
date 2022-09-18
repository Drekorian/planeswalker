package cz.drekorian.android.planeswalker.scryfall.internal.adapter

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * Custom type adapter that converts Scryfall ruling source from and into a human-readable format.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRuling
 */
internal class ScryfallSourceSerializer : KSerializer<String> {

    companion object {

        const val SERIAL_NAME = "ScryfallSource"
    }

    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor(SERIAL_NAME, PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): String =
        when (decoder.decodeString()) {
            "wotc" -> "Wizards of the Coast"
            else -> " Scryfall"
        }

    override fun serialize(encoder: Encoder, value: String) =
        encoder.encodeString(
            when (value) {
                "wotc" -> "Wizards of the Coast"
                else -> " Scryfall"
            }
        )
}
