/*
 *      GUIHelper2 - Create and manage Minecraft GUIs
 *
 *         The MIT License (MIT)
 *
 *      Copyright (c) 2017 Sandstone (https://github.com/ProjectSandstone) <https://github.com/ProjectSandstone/GUIHelper2>
 *      Copyright (c) contributors
 *
 *
 *      Permission is hereby granted, free of charge, to any person obtaining a copy
 *      of this software and associated documentation files (the "Software"), to deal
 *      in the Software without restriction, including without limitation the rights
 *      to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *      copies of the Software, and to permit persons to whom the Software is
 *      furnished to do so, subject to the following conditions:
 *
 *      The above copyright notice and this permission notice shall be included in
 *      all copies or substantial portions of the Software.
 *
 *      THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *      IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *      FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *      AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *      LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *      OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */
package com.github.projectsandstone.guihelper2.platform.init;

import com.github.projectsandstone.guihelper2.platform.annotation.Module;
import com.github.projectsandstone.guihelper2.platform.registry.GameRegistry;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public final class RegistryInit {

    public static void initRegistry(Class<?> aClass) {
        String module = aClass.getDeclaredAnnotation(Module.class).value();

        for (Field field : aClass.getDeclaredFields()) {
            if (Modifier.isStatic(field.getModifiers()) && GameRegistry.class.isAssignableFrom(field.getType())) {
                String fieldName = field.getName();
                String registryId = module + ":" + fieldName.toLowerCase();
                String registryName = RegistryInit.toRegistryName(fieldName);

                try {
                    field.setAccessible(true);

                    Field modifiers = Field.class.getDeclaredField("modifiers");
                    modifiers.setAccessible(true);
                    modifiers.setInt(field, field.getModifiers() & ~Modifier.FINAL);

                    Constructor<?> constructor = field.getType().getConstructor(String.class, String.class);

                    constructor.setAccessible(true);

                    field.set(null, constructor.newInstance(registryId, registryName));
                } catch (Throwable t) {
                    throw new RuntimeException("Failed to register '" + field + "' with id = " + registryId + " and name = " + registryName, t);
                }
            }
        }
    }


    private static String toRegistryName(String name) {
        StringBuilder sb = new StringBuilder();
        char[] chars = name.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];

            if (i == 0 || i - 1 > 0 && chars[i - 1] == '_')
                sb.append(Character.toUpperCase(c));
            else if (c == '_')
                sb.append(' ');
            else
                sb.append(Character.toUpperCase(c));
        }

        return sb.toString();
    }


}
