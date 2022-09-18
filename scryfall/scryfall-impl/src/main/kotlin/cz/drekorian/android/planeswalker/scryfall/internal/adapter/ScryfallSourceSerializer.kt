package cz.drekorian.android.planeswalker.scryfall.internal.adapter

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import javax.inject.Singleton

/**
 * Custom type adapter that converts Scryfall ruling source from and into a human-readable format.
 *
 * @see cz.drekorian.android.planeswalker.scryfall.api.model.ScryfallRuling
 */
@Singleton
internal class ScryfallSourceSerializer : KSerializer<String> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("ScryfallSource", PrimitiveKind.STRING)

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
