/*
 * This file is part of Dependency-Track.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * SPDX-License-Identifier: Apache-2.0
 * Copyright (c) OWASP Foundation. All Rights Reserved.
 */
package org.dependencytrack.vulnmirror;

import io.quarkus.runtime.annotations.RegisterForReflection;
import io.csaf.schema.generated.Aggregator;
import io.csaf.schema.generated.Csaf;
import io.csaf.schema.generated.Provider;
import io.csaf.schema.generated.ROLIEFeed;

// This class is needed since the native build of the mirror-service does
// not include the serializers for io.csaf.schema.generated.*.
@RegisterForReflection(
        targets = {
                Aggregator.class,
                Csaf.class,
                Provider.class,
                ROLIEFeed.class
        }
)
public class ExternalReflectionConfig {
}