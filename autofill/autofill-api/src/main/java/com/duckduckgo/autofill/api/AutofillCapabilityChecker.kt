/*
 * Copyright (c) 2023 DuckDuckGo
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

package com.duckduckgo.autofill.api

/**
 * Used to check the status of Autofill features.
 * This is the public API that should be used by the app to check the status of Autofill features.

 * see also: InternalAutofillCapabilityChecker
 */
interface AutofillCapabilityChecker {

    suspend fun canAccessCredentialManagementScreen(): Boolean
}
