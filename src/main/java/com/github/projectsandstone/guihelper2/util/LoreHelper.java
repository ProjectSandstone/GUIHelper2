/*
 * GUIHelper2 - Create and manage Minecraft GUIs
 *
 * The MIT License (MIT)
 *
 * Copyright (c) 2017 Sandstone (https://github.com/ProjectSandstone)
 * <https://github.com/ProjectSandstone/GUIHelper2> Copyright (c) contributors
 *
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and
 * associated documentation files (the "Software"), to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute,
 * sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or
 * substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT
 * NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM,
 * DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package com.github.projectsandstone.guihelper2.util;

import java.util.ArrayList;
import java.util.List;

public final class LoreHelper {

  public final List<String> lore = new ArrayList<>();

  /**
   * Add a new line to the lore.
   *
   * @param lore The literal text you want to add to the end of the lore (as a new line).
   * @return The modified instance to you continue building.
   */
  public LoreHelper add(String lore) {
    this.lore.add(lore);
    return this;
  }

  /**
   * Instead of adding line per line you can add all through passing a array of Strings.
   *
   * @param lines All lines you want to add to the end of lore. Every line will be added with
   *        {@link #add(String)}
   * @return The modified instance to you continue building.
   */
  public LoreHelper addAll(String... lines) {
    for (String line : lines) {
      this.add(line);
    }

    return this;
  }

  /**
   * Remove all lines from the lore, cleaning it.
   *
   * @return The modified instance to you continue building.
   */
  public LoreHelper clear() {
    this.lore.clear();
    return this;
  }

  /**
   * Get how much lines have in the lore.
   *
   * @return Returns the quantity of lines.
   */
  public int countLines() {
    return this.lore.size();
  }

}
