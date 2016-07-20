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

package io.github.myessentials.mytown2.config;

import io.github.myessentials.mytown2.MyTown2;
import ninja.leaping.configurate.commented.CommentedConfigurationNode;
import ninja.leaping.configurate.loader.ConfigurationLoader;
import ninja.leaping.configurate.objectmapping.ObjectMapper;
import ninja.leaping.configurate.objectmapping.ObjectMappingException;

import java.io.IOException;

public class ConfigManager {
    private ObjectMapper<Config> configObjectMapper;
    private ConfigurationLoader<CommentedConfigurationNode> configLoader;
    private CommentedConfigurationNode configRoot;
    public Config config;

    public ConfigManager() {
        try {
            configObjectMapper = ObjectMapper.forClass(Config.class);
        } catch (ObjectMappingException e) {
            MyTown2.getLogger().error("Failed to make config object mapper", e);
        }
    }

    public boolean load() {
        MyTown2.getLogger().info("Loading configuration");
        try {
            configRoot = configLoader.load();
            config = configObjectMapper.bindToNew().populate(configRoot);
        } catch (IOException | ObjectMappingException e) {
            MyTown2.getLogger().error("Failed to load config", e);
            return false;
        }
        return true;
    }

    public boolean save() {
        MyTown2.getLogger().info("Saving configuration");
        try {
            configObjectMapper.bind(config).serialize(configRoot);
            configLoader.save(configRoot);
        } catch (IOException | ObjectMappingException e) {
            MyTown2.getLogger().error("Failed to save config", e);
            return false;
        }
        return true;
    }

    public void setLoader(ConfigurationLoader<CommentedConfigurationNode> loader) {
        this.configLoader = loader;
    }
}
