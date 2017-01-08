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
package com.github.projectsandstone.guihelper2.gui;

import com.github.projectsandstone.guihelper2.content.Action;
import com.github.projectsandstone.guihelper2.content.Content;
import com.github.projectsandstone.guihelper2.handler.Handler;

public final class Slot {

    /**
     * Gets the item provided to the slot.
     */
    private final Content.ItemContent content;

    /**
     * Handler to handle the action.
     */
    private final Handler actionHandler;

    public Slot(Content.ItemContent content, Handler actionHandler) {
        this.content = content;
        this.actionHandler = actionHandler;
    }

    public Content.ItemContent getContent() {
        return content;
    }

    public Object handle(Action action) {
        return this.actionHandler.handle(action);
    }
}
