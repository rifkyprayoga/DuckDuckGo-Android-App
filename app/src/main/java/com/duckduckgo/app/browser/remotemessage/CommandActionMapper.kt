/*
 * Copyright (c) 2022 DuckDuckGo
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.duckduckgo.app.browser.remotemessage

import com.duckduckgo.app.browser.commands.Command
import com.duckduckgo.app.browser.commands.Command.*
import com.duckduckgo.remote.messaging.api.Action
import com.duckduckgo.remote.messaging.api.Action.*

fun Action.asBrowserTabCommand(): Command? {
    return when (this) {
        is Dismiss -> {
            null
        }
        is PlayStore -> LaunchPlayStore(this.value)
        is Url -> SubmitUrl(this.value)
        is DefaultBrowser -> LaunchDefaultBrowser
        is AppTpOnboarding -> LaunchAppTPOnboarding
        is Share -> SharePromoLinkRMF(this.value, this.title)
        is Navigation -> { LaunchScreen(this.value, this.additionalParameters?.get("payload").orEmpty()) }
    }
}
