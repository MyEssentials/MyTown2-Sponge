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

import java.util.Map;

/**
 * Holds a named value of a generic type
 *
 * @param <T>
 */
public final class Flag<T> implements Comparable<Flag> {
    private T value;
    private final FlagType<T> type;

    public Flag(FlagType<T> type, T value) {
        this.type = type;
        this.value = value;
    }

    /**
     * Returns the value of this {@link Flag}
     *
     * @return The value
     */
    public T getValue() {
        return value;
    }

    /**
     * Sets the value of this {@link Flag}
     *
     * @param value The value to set to
     */
    public void setValue(T value) {
        this.value = value;
    }

    /**
     * Sets the value of this {@link Flag} from the given {@link String}
     *
     * @param value The string of the value
     */
    public void setValue(String value) {
        if (type.getType() == Boolean.class) {
            this.value = (T) Boolean.valueOf(value);
        } else if (type.getType() == String.class) {
            this.value = (T) value;
        } else if (type.getType() == Integer.class) {
            this.value = (T) Integer.valueOf(value);
        } else if (type.getType() == Float.class) {
            this.value = (T) Float.valueOf(value);
        }
    }

    /**
     * Toggle the value if its a Boolean flag
     */
    public void toggle() {
        if (type.getType() == Boolean.class) {
            this.value = (T) Boolean.valueOf(!((Boolean) this.value));
        }
    }

    /**
     * Returns the {@link FlagType} of this {@link Flag}
     *
     * @return The {@link FlagType}
     */
    public FlagType<T> getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("%s{%s}", type.getId(), value);
    }

    @Override
    public int compareTo(Flag o) {
        return type.compareTo(o.type);
    }

    /**
     * An immutable {@link Map} of {@link Flag}s keyed by their {@link FlagType}
     */
    public interface Container extends Map<FlagType<?>, Flag> {
        /**
         * Returns the value of the given {@link FlagType}
         *
         * @param flagType The {@link FlagType} to get value of
         * @param <T>      The type of value
         * @return The actual value or null if {@link FlagType} doesn't exist
         */
        default <T> T getValue(FlagType<T> flagType) {
            Flag<T> flag = get(flagType);

            if (flag != null) {
                return flag.value;
            }

            return null;
        }
    }
}
