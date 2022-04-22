/*
 *   __   __     __  __     __         __
 *  /\ "-.\ \   /\ \/\ \   /\ \       /\ \
 *  \ \ \-.  \  \ \ \_\ \  \ \ \____  \ \ \____
 *   \ \_\\"\_\  \ \_____\  \ \_____\  \ \_____\
 *    \/_/ \/_/   \/_____/   \/_____/   \/_____/
 *   ______     ______       __     ______     ______     ______
 *  /\  __ \   /\  == \     /\ \   /\  ___\   /\  ___\   /\__  _\
 *  \ \ \/\ \  \ \  __<    _\_\ \  \ \  __\   \ \ \____  \/_/\ \/
 *   \ \_____\  \ \_____\ /\_____\  \ \_____\  \ \_____\    \ \_\
 *    \/_____/   \/_____/ \/_____/   \/_____/   \/_____/     \/_/
 *
 * https://joshbassett.info
 * https://twitter.com/nullobject
 * https://github.com/nullobject
 *
 * Copyright (c) 2022 Josh Bassett
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package cave.types

import axon.mem.ReadMemIO
import cave.Config
import chisel3._

/** An bundle that contains all the required signals for the sprite processor. */
class SpriteIO extends Bundle {
  /** Graphics format */
  val format = Input(UInt(Config.GFX_FORMAT_WIDTH.W))
  /** Asserted when the layer is enabled */
  val enable = Input(Bool())
  /** Asserted when the layer flipped */
  val flip = Input(Bool())
  /** Asserted when the layer rotated */
  val rotate = Input(Bool())
  /** Asserted when sprite scaling is enabled */
  val zoom = Input(Bool())
  /** Sprite bank */
  val bank = Input(Bool())
  /** VRAM port */
  val vram = ReadMemIO(Config.SPRITE_RAM_GPU_ADDR_WIDTH, Config.SPRITE_RAM_GPU_DATA_WIDTH)
  /** Tile ROM port */
  val rom = new SpriteRomIO
}

object SpriteIO {
  def apply() = new SpriteIO
}