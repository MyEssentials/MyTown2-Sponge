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

package io.github.myessentials.mytown2.api.entities.flags;

import com.google.common.collect.ImmutableSet;
import org.spongepowered.api.CatalogType;

public abstract class FlagType<T> implements CatalogType, Comparable<FlagType> {
    /**
     * Returns the type of the {@link Flag}
     *
     * @return The type
     */
    public abstract Class<T> getType();

    /**
     * Returns the properties of this {@link FlagType}
     *
     * @return The properties
     */
    public abstract ImmutableSet<Property> getProperties();

    /**
     * Returns the default value of the {@link Flag}
     *
     * @return The default value
     */
    public abstract T defaultValue();

    /**
     * Returns the default value in the wild of the {@link Flag}
     *
     * @return The default value in the wild
     */
    public abstract T defaultWildValue();

    /**
     * Creates a new {@link Flag} of this {@link FlagType} with the given value
     *
     * @param value The value of the new {@link Flag}
     * @return The new {@link Flag}
     */
    public final Flag<T> newFlag(T value) {
        return new Flag<>(this, value);
    }

    /**
     * Creates a new {@link Flag} of this {@link FlagType} with the default value
     *
     * @return The new {@link Flag}
     */
    public final Flag<T> newFlag() {
        return newFlag(defaultValue());
    }

    /**
     * Creates a new {@link Flag} of this {@link FlagType} with the default wild value
     *
     * @return The new {@link Flag}
     */
    public final Flag<T> newWildFlag() {
        return newFlag(defaultWildValue());
    }

    /**
     * Returns if this {@link FlagType} is a town {@link Flag}
     *
     * @return If a town {@link Flag}
     */
    public final boolean isTownFlag() {
        return getProperties().contains(Property.IN_TOWN);
    }

    /**
     * Returns if this {@link FlagType} is a plot {@link Flag}
     *
     * @return If a plot {@link Flag}
     */
    public final boolean isPlotFlag() {
        return getProperties().contains(Property.IN_PLOT);
    }

    /**
     * Returns if this {@link FlagType} is a wild {@link Flag}
     *
     * @return If a wild {@link Flag}
     */
    public final boolean isWildFlag() {
        return getProperties().contains(Property.IN_WILD);
    }

    /**
     * Returns if this {@link FlagType} is able to have a whitelist associated to it
     *
     * @return If able to have a whitelist
     */
    public final boolean isWhitelistable() {
        return getProperties().contains(Property.WHITELISTABLE);
    }

    /**
     * Returns the bypass permission node for this {@link FlagType}
     *
     * @return The bypass permission node
     */
    public final String getBypassPermission() {
        return "mytown.bypass.flag." + getId().toLowerCase();
    }

    @Override
    public final int compareTo(FlagType o) {
        // Making it lowercase to match how CatalogType works (case-insensitive)
        return getId().toLowerCase().compareTo(o.getId().toLowerCase());
    }

    @Override
    public final String toString() {
        return String.format("%s{defaultValue=%s, defaultWildValue=%s, properties=%s}", getId(), defaultValue(), defaultWildValue(), getProperties());
    }

    public enum Property {
        IN_TOWN,
        IN_PLOT,
        IN_WILD,
        WHITELISTABLE
    }
}
