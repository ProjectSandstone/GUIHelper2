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
package com.github.projectsandstone.guihelper2.platform.factory;

import com.github.projectsandstone.guihelper2.platform.item.ItemStack;
import com.github.projectsandstone.guihelper2.platform.item.ItemType;

import java.util.List;

public interface ItemStackFactory {

    /**
     * Create a instance of {@link ItemStack}.
     *
     * @param itemType  Type of the item.
     * @param stackSize Amount of the item.
     * @return New instance of {@link ItemStack}.
     */
    default ItemStack createItemStack(ItemType itemType, int stackSize) {
        return this.createItemStack(itemType, stackSize, null, null);
    }

    /**
     * Create a instance of {@link ItemStack}.
     *
     * @param itemType    Type of the item.
     * @param stackSize   Amount of the item.
     * @param displayName Display name of the item.
     * @return New instance of {@link ItemStack}.
     */
    default ItemStack createItemStack(ItemType itemType, int stackSize, String displayName) {
        return this.createItemStack(itemType, stackSize, displayName, null);
    }

    /**
     * Create a instance of {@link ItemStack}.
     *
     * @param itemType    Type of the item.
     * @param stackSize   Amount of the item.
     * @param displayName Display name of the item.
     * @param lore        Lore of the item.
     * @return New instance of {@link ItemStack}.
     */
    ItemStack createItemStack(ItemType itemType, int stackSize, String displayName, List<String> lore);

}
