/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org/>
 */

package io.github.myessentials.mytown2.api.entities;

import io.github.myessentials.mytown2.api.entities.flags.Flag;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.Identifiable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface World extends Identifiable, TextRepresentable, Comparable<World> {
    /**
     * Returns the Sponge {@link org.spongepowered.api.world.World} for this {@link World}
     *
     * If the {@link World} is on a different {@link Server} it returns an empty {@link Optional}
     *
     * @return The Sponge {@link org.spongepowered.api.world.World}
     */
    Optional<org.spongepowered.api.world.World> getWorld();

    /**
     * Returns the {@link Flag}s this {@link World} has
     *
     * @return The {@link Flag}s
     */
    Flag.Container flags();

    /**
     * A {@link Map} of {@link World}s keyed by their {@link UUID}
     */
    interface Container extends Map<UUID, World> {
    }
}
