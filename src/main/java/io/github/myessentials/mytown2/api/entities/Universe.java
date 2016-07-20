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

/**
 * Encompasses the entire MyTown2 universe
 *
 * This is registered as a Sponge service
 */
public interface Universe {
    /**
     * Returns the {@link Server.Container} of all {@link Server}s in the MyTown2 Universe
     *
     * @return The {@link Server}s
     */
    Server.Container getServers();

    /**
     * Get this current {@link Server}
     *
     * @return The {@link Server}
     */
    Server getCurrentServer();

    /**
     * Returns the {@link Resident.Container} of all {@link Resident}s in the MyTown2 Universe
     *
     * @return The {@link Resident}s
     */
    Resident.Container getResidents();

    /**
     * Returns the {@link Town.Container} of all {@link Town}s in the MyTown2 Universe
     *
     * @return The {@link Town}s
     */
    Town.Container getTowns();

    /**
     * Returns the {@link Nation.Container} of all {@link Nation}s in the MyTown2 Universe
     *
     * @return The {@link Nation}s
     */
    Nation.Container getNations();
}
