/*
   Copyright 2016 Thomas Nappo

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */

package org.jire.arrowhead

import com.sun.jna.Platform
import org.jire.arrowhead.windows.User32

/**
 * Returns the key state of the specified virtual key code.
 *
 * @param virtualKeyCode The key code of which to check the state.
 * @throws UnsupportedOperationException If the platform is not supported.
 */
fun keyState(virtualKeyCode: Int): Int = when {
	Platform.isWindows() || Platform.isWindowsCE() -> User32.GetKeyState(virtualKeyCode).toInt()
	else -> throw UnsupportedOperationException("Unsupported platform (osType=${Platform.getOSType()}")
}