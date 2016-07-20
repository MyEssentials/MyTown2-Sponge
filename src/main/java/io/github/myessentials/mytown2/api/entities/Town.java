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
import org.spongepowered.api.service.economy.account.Account;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.text.channel.MessageChannel;
import org.spongepowered.api.util.Identifiable;

import javax.annotation.Nonnull;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface Town extends Identifiable, TextRepresentable, Comparable<Town> {
    /**
     * Returns the name of this {@link Town}
     *
     * @return Name of town
     */
    String getName();

    /**
     * Renames the {@link Town}
     *
     * @param newName The new name
     */
    void rename(@Nonnull String newName);

    int getExtraBlocks();

    void setExtraBlocks(int blocks);

    int getExtraFarClaims();

    void setExtraFarClaims(int claims);

    // TODO: Spawn point

    /**
     * Returns the {@link Account} for this {@link Town}
     *
     * @return The {@link Account}
     */
    Optional<Account> getBankAccount();

    /**
     * Returns the {@link MessageChannel} for the Residents in this {@link Town}
     *
     * @return The {@link MessageChannel}
     */
    MessageChannel getChannel();

    /**
     * Returns the {@link Flag}s this {@link Town} has
     *
     * @return The {@link Flag}s
     */
    Flag.Container flags();

    /**
     * Returns the {@link Resident}s of this {@link Town}
     *
     * @return The {@link Resident}s
     */
    Resident.Container residents();

    /**
     * Returns the {@link TownBlock}s of this {@link Town}
     *
     * @return {@link TownBlock}s
     */
    TownBlock.Container blocks();

    /**
     * Returns the {@link Plot}s of this {@link Town}
     *
     * @return {@link Plot}s
     */
    Plot.Container plots();

    /**
     * A {@link Map} of {@link Town}s keyed by their {@link UUID}
     */
    interface Container extends Map<UUID, Town> {
        /**
         * Gets the {@link Town} by the name
         *
         * @param name The nameof the {@link Town}
         * @return The {@link Town}
         */
        default Town get(String name) {
            for (Town town : this.values()) {
                if (town.getName().equals(name)) {
                    return town;
                }
            }

            return null;
        }

        /**
         * Checks if the {@link Town} with the name exists
         *
         * @param name The name to check for
         * @return If the {@link Town} exists
         */
        default boolean contains(String name) {
            for (Town town : this.values()) {
                if (town.getName().equals(name)) {
                    return true;
                }
            }

            return false;
        }
    }
}
