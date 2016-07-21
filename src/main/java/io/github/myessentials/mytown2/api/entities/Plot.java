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

import com.flowpowered.math.vector.Vector3i;
import io.github.myessentials.mytown2.api.entities.flags.Flag;
import org.spongepowered.api.text.TextRepresentable;
import org.spongepowered.api.util.Identifiable;
import org.spongepowered.api.world.extent.Extent;

import java.util.List;

public interface Plot extends Identifiable, TextRepresentable, Comparable<Plot> {
    /**
     * Returns the {@link Flag}s this {@link Plot} has
     *
     * @return The {@link Flag}s
     */
    Flag.Container flags();

    /**
     * Returns the members of this {@link Plot}
     *
     * @return The members
     */
    Resident.Container members();

    /**
     * Returns the owners of this {@link Plot}
     *
     * @return The owners
     */
    Resident.Container owners();

    /**
     * Returns the {@link World} this {@link Plot} is in
     *
     * @return The {@link World}
     */
    World world();

    /**
     * Returns the {@link Town} this {@link Plot} is part of
     *
     * @return The {@link Town}
     */
    Town town();

    /**
     * Returns the start position of this {@link Plot}
     *
     * @return The start position
     */
    Vector3i getStart();

    /**
     * Returns the end position of this {@link Plot}
     *
     * @return The end position
     */
    Vector3i getEnd();

    /**
     * Returns the {@link Extent} of this {@link Plot}
     *
     * @return The {@link Extent}
     */
    default Extent getExtent() {
        return world().getWorld().get().getExtentView(getStart(), getEnd());
    }

    interface Container extends List<Plot> {
    }
}
