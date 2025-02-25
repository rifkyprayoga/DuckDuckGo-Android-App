/*
 * Copyright (c) 2021 DuckDuckGo
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

package com.duckduckgo.remote.messaging.impl.models

import com.duckduckgo.remote.messaging.api.JsonMatchingAttribute
import com.duckduckgo.remote.messaging.api.JsonMessageAction

data class JsonRemoteMessagingConfig(
    val version: Long,
    val messages: List<JsonRemoteMessage>,
    val rules: List<JsonMatchingRule>,
)

data class JsonRemoteMessage(
    val id: String,
    val content: JsonContent?,
    val exclusionRules: List<Int>,
    val matchingRules: List<Int>,
    val translations: Map<String, JsonContentTranslations>,
)

data class JsonContent(
    val messageType: String = "",
    val titleText: String = "",
    val descriptionText: String = "",
    val placeholder: String = "",
    val primaryActionText: String = "",
    val primaryAction: JsonMessageAction? = null,
    val secondaryActionText: String = "",
    val secondaryAction: JsonMessageAction? = null,
    val actionText: String = "",
    val action: JsonMessageAction? = null,
)

data class JsonContentTranslations(
    val messageType: String = "",
    val titleText: String = "",
    val descriptionText: String = "",
    val primaryActionText: String = "",
    val secondaryActionText: String = "",
    val actionText: String = "",
)

data class JsonMatchingRule(
    val id: Int,
    val attributes: Map<String, JsonMatchingAttribute>,
)

sealed class JsonMessageType(val jsonValue: String) {
    object SMALL : JsonMessageType("small")
    object MEDIUM : JsonMessageType("medium")
    object BIG_SINGLE_ACTION : JsonMessageType("big_single_action")
    object BIG_TWO_ACTION : JsonMessageType("big_two_action")
    object PROMO_SINGLE_ACTION : JsonMessageType("promo_single_action")
}
