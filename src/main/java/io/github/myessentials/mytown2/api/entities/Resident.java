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

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.Identifiable;

import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface Resident extends Identifiable, TextRepresentable, Comparable<Resident> {
    /**
     * Returns the {@link User} of this {@link Resident}
     *
     * @return The {@link User}
     */
    User getUser();

    /**
     * Returns the username of the underlying {@link User}
     * @return The username of the {@link User}
     */
    default String getName() {
        return getUser().getName();
    }

    /**
     * Returns if the {@link Resident} is currently online
     *
     * @return If the player is currently online
     */
    default boolean isOnline() {
        return getUser().isOnline();
    }

    /**
     * Returns the {@link Player} if currently online
     *
     * @return Returns the {@link Player} if online
     */
    default Optional<Player> getPlayer() {
        return getUser().getPlayer();
    }

    /**
     * Returns the number of extra blocks given to this {@link Resident}
     *
     * @return Number of extra blocks
     */
    int getExtraBlocks();

    /**
     * Sets the number of extra blocks given to this {@link Resident}
     *
     * @param extraBlocks Number of extra blocks
     */
    void setExtraBlocks(int extraBlocks);

    /**
     * Returns the {@link Town}s this {@link Resident} belongs to
     *
     * @return The {@link Town}s
     */
    Town.Container towns();

    /**
     * Returns the {@link Town}s this {@link Resident} has an invite to
     *
     * @return The {@link Town}s
     */
    Town.Container townInvites();

    /**
     * Returns the {@link Plot}s this {@link Resident} owns
     *
     * @return The {@link Plot}s
     */
    Plot.Container plots();

    /**
     * A {@link Map} of {@link Resident}s keyed by their {@link UUID}
     */
    interface Container extends Map<UUID, Resident> {
        /**
         * Gets the {@link Resident} by the username
         *
         * @param username The username of the {@link Resident}
         * @return The {@link Resident}
         */
        default Resident get(String username) {
            for (Resident res : this.values()) {
                if (res.getUser().getName().equals(username)) {
                    return res;
                }
            }

            return null;
        }

        /**
         * Checks if the {@link Resident} with the username exists
         *
         * @param username The username to check for
         * @return If the {@link Resident} exists
         */
        default boolean contains(String username) {
            for (Resident res : this.values()) {
                if (res.getUser().getName().equals(username)) {
                    return true;
                }
            }

            return false;
        }
    }
}
