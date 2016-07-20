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

package io.github.myessentials.mytown2.core.entities.flags;

import com.google.common.collect.ImmutableMap;
import io.github.myessentials.mytown2.api.entities.flags.Flag;
import io.github.myessentials.mytown2.api.entities.flags.FlagType;
import org.spongepowered.api.Sponge;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public final class FlagContainer implements Flag.Container {
    public static Flag.Container AllFlags() {
        Collection<FlagType> types = Sponge.getRegistry().getAllOf(FlagType.class);
        Map<FlagType<?>, Flag<?>> flags = new HashMap<>();
        types.stream().forEach(type -> flags.put(type, type.newFlag()));

        return new FlagContainer(flags);
    }

    /**
     * Returns a new {@link Flag.Container} holding town flags only
     * @return The new {@link Flag.Container}
     */
    public static Flag.Container TownFlags() {
        Collection<FlagType> types = Sponge.getRegistry().getAllOf(FlagType.class);

        Map<FlagType<?>, Flag<?>> flags = new HashMap<>();
        types.stream().filter(FlagType::isTownFlag).forEach(type -> flags.put(type, type.newFlag()));

        return new FlagContainer(flags);
    }

    /**
     * Returns a new {@link Flag.Container} holding plot flags only
     * @return The new {@link Flag.Container}
     */
    public static Flag.Container PlotFlags() {
        Collection<FlagType> types = Sponge.getRegistry().getAllOf(FlagType.class);

        Map<FlagType<?>, Flag<?>> flags = new HashMap<>();
        types.stream().filter(FlagType::isPlotFlag).forEach(type -> flags.put(type, type.newFlag()));

        return new FlagContainer(flags);
    }

    /**
     * Returns a new {@link Flag.Container} holding wild flags only
     * @return The new {@link Flag.Container}
     */
    public static Flag.Container WildFlags() {
        Collection<FlagType> types = Sponge.getRegistry().getAllOf(FlagType.class);

        Map<FlagType<?>, Flag<?>> flags = new HashMap<>();
        types.stream().filter(FlagType::isWildFlag).forEach(type -> flags.put(type, type.newWildFlag()));

        return new FlagContainer(flags);
    }

    private final ImmutableMap<FlagType<?>, Flag> flags;

    public FlagContainer(Map<FlagType<?>, Flag<?>> flags) {
        this.flags = ImmutableMap.copyOf(flags);
    }

    @Override
    public int size() {
        return flags.size();
    }

    @Override
    public boolean isEmpty() {
        return flags.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return flags.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return flags.containsValue(value);
    }

    @Override
    public Flag get(Object key) {
        return flags.get(key);
    }

    @Override
    public Set<FlagType<?>> keySet() {
        return flags.keySet();
    }

    @Override
    public Collection<Flag> values() {
        return flags.values();
    }

    @Override
    public Set<Entry<FlagType<?>, Flag>> entrySet() {
        return flags.entrySet();
    }

    @Override
    @Deprecated
    public Flag put(FlagType<?> key, Flag value) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public Flag remove(Object key) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void putAll(Map<? extends FlagType<?>, ? extends Flag> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    @Deprecated
    public void clear() {
        throw new UnsupportedOperationException();
    }
}
