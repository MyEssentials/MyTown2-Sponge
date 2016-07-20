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

package io.github.myessentials.mytown2.core.entities.flags.impl;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;
import io.github.myessentials.mytown2.api.entities.flags.impl.BooleanFlagType;

public class EntitiesFlagType extends BooleanFlagType {
    public static final EntitiesFlagType typeInstance = new EntitiesFlagType();
    private static final ImmutableSet<Property> properties = Sets.immutableEnumSet(Property.IN_TOWN, Property.IN_PLOT, Property.IN_WILD);

    @Override
    public String getId() {
        return "ENTITIES";
    }

    @Override
    public String getName() {
        return "ENTITIES";
    }

    @Override
    public ImmutableSet<Property> getProperties() {
        return properties;
    }

    @Override
    public Boolean defaultValue() {
        return true;
    }

    @Override
    public Boolean defaultWildValue() {
        return true;
    }
}
