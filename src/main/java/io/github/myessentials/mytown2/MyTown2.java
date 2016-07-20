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

package io.github.myessentials.mytown2;

import com.google.inject.Inject;
import io.github.myessentials.mytown2.api.entities.flags.FlagType;
import io.github.myessentials.mytown2.config.Config;
import io.github.myessentials.mytown2.config.ConfigManager;
import io.github.myessentials.mytown2.registries.FlagRegistry;
import me.flibio.updatifier.Updatifier;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import org.slf4j.Logger;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.config.ConfigDir;
import org.spongepowered.api.config.DefaultConfig;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.game.GameReloadEvent;
import org.spongepowered.api.event.game.state.*;
import org.spongepowered.api.plugin.Plugin;

import java.nio.file.Path;

import static io.github.myessentials.mytown2.PluginInfo.*;

@Plugin(id = ID, name = NAME, version = VERSION, description = DESCRIPTION, authors = {"Alpha", "Legobear154"})
@Updatifier(repoName = REPO_NAME, repoOwner = REPO_OWNER, version = UPDATIFIER_VERSION)
public class MyTown2 {
    public static MyTown2 instance;

    public static Logger getLogger() {
        return instance.logger;
    }

    public static Config getConfig() {
        return instance.configManager.config;
    }

    public static Path getConfigDir() {
        return instance.configDir;
    }

    @Inject
    @ConfigDir(sharedRoot = false)
    private Path configDir;

    private Logger logger;
    private final ConfigManager configManager = new ConfigManager();

    @Listener
    public void onConstruction(GameConstructionEvent ev) {
        instance = this;
    }

    @Listener
    public void onPreInit(GamePreInitializationEvent ev) {
        // Load the config
        configManager.load();

        // Register registries
        Sponge.getRegistry().registerModule(FlagType.class, new FlagRegistry());
    }

    @Listener
    public void onInit(GameInitializationEvent ev) {
    }

    @Listener
    public void onPostInit(GamePostInitializationEvent ev) {
    }

    @Listener
    public void onServerStarting(GameStartingServerEvent ev) {
    }

    @Listener
    public void onServerStopped(GameStoppedEvent ev) {
    }

    public void onReload(GameReloadEvent ev) {
        // TODO: Reload plugin (Config, etc)
    }

    @Inject
    private void setLoader(@DefaultConfig(sharedRoot = false) ConfigurationLoader<CommentedConfigurationNode> loader) {
        configManager.setLoader(loader);
    }

    @Inject
    private void setLogger(Logger logger) {
        this.logger = logger; // TODO: Replace with a custom logger wrapper
    }
}
