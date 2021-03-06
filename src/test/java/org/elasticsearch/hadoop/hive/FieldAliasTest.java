/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.elasticsearch.hadoop.hive;

import java.util.Properties;

import org.junit.Test;

import static org.junit.Assert.*;

public class FieldAliasTest {

    @Test
    public void testFieldMap() throws Exception {
        Properties tableProperties = new Properties();
        tableProperties.put("es.column.aliases", "timestamp:@timestamp , foo:123foo");
        FieldAlias alias = HiveUtils.alias(tableProperties);
        assertEquals("@timestamp", alias.toES("timestamp"));
        assertEquals("123foo", alias.toES("foo"));
        assertEquals("bar", alias.toES("BaR"));

    }
}
