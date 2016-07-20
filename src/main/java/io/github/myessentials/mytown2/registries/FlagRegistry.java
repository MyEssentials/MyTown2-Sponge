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

package io.github.myessentials.mytown2.registries;

import com.google.common.collect.ImmutableList;
import io.github.myessentials.mytown2.api.entities.flags.FlagType;
import io.github.myessentials.mytown2.core.entities.flags.impl.*;
import org.spongepowered.api.registry.CatalogRegistryModule;
import org.spongepowered.api.registry.RegistrationPhase;
import org.spongepowered.api.registry.util.DelayedRegistration;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

public class FlagRegistry implements CatalogRegistryModule<FlagType> {
    private final Map<String, FlagType> flagMappings = new HashMap<>();

    @Override
    public Optional<FlagType> getById(String id) {
        return Optional.ofNullable(flagMappings.get(checkNotNull(id).toLowerCase()));
    }

    @Override
    public Collection<FlagType> getAll() {
        return ImmutableList.copyOf(flagMappings.values());
    }

    private void register(FlagType flagType) {
        flagMappings.put(checkNotNull(flagType).getId().toLowerCase(), flagType);
    }

    @Override
    @DelayedRegistration(RegistrationPhase.INIT)
    public void registerDefaults() {
        register(AccessFlagType.typeInstance);
        register(ActivateFlagType.typeInstance);
        register(EnterFlagType.typeInstance);
        register(EntitiesFlagType.typeInstance);
        register(ExplosionsFlagType.typeInstance);
        register(FakersFlagType.typeInstance);
        register(MobsFlagType.typeInstance);
        register(ModifyFlagType.typeInstance);
        register(NearbyFlagType.typeInstance);
        register(PickupFlagType.typeInstance);
        register(PVEFlagType.typeInstance);
        register(PVPFlagType.typeInstance);
        register(RestrictionsFlagType.typeInstance);
        register(UsageFlagType.typeInstance);
    }
}
