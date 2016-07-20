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

import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.Identifiable;

import javax.annotation.Nullable;
import java.util.Map;
import java.util.UUID;

public interface Nation extends Identifiable, TextRepresentable, Comparable<Nation> {
    /**
     * Returns the name of the {@link Nation}
     *
     * @return The name
     */
    String getName();

    /**
     * Renames the {@link Nation}
     *
     * @param newName The new name
     */
    void rename(String newName);

    /**
     * Returns the {@link Town}s that are part of this {@link Nation}
     *
     * @return The {@link Town}s
     */
    Town.Container towns();

    /**
     * A {@link Map} of {@link Nation}s keyed by their {@link UUID}
     */
    interface Container extends Map<UUID, Nation> {
        default Nation get(String name) {
            for (Nation nation : this.values()) {
                if (nation.getName().equals(name)) {
                    return nation;
                }
            }

            return null;
        }

        default boolean contains(String name) {
            for (Nation nation : this.values()) {
                if (nation.getName().equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }
}
