/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.seatunnel.connectors.seatunnel.timeplus.sink.file;

import org.apache.seatunnel.api.configuration.util.OptionRule;
import org.apache.seatunnel.api.table.factory.Factory;
import org.apache.seatunnel.api.table.factory.TableSinkFactory;

import com.google.auto.service.AutoService;

import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.COMPATIBLE_MODE;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.COPY_METHOD;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.DATABASE;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.FILE_FIELDS_DELIMITER;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.FILE_TEMP_PATH;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.HOST;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.NODE_FREE_PASSWORD;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.NODE_PASS;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.PASSWORD;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.SHARDING_KEY;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.TABLE;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.TIMEPLUS_LOCAL_PATH;
import static org.apache.seatunnel.connectors.seatunnel.timeplus.config.TimeplusConfig.USERNAME;

@AutoService(Factory.class)
public class TimeplusFileSinkFactory implements TableSinkFactory {
    @Override
    public String factoryIdentifier() {
        return "ClickhouseFile";
    }

    @Override
    public OptionRule optionRule() {
        return OptionRule.builder()
                .required(HOST, TABLE, DATABASE, USERNAME, PASSWORD, TIMEPLUS_LOCAL_PATH)
                .optional(
                        COPY_METHOD,
                        SHARDING_KEY,
                        NODE_FREE_PASSWORD,
                        NODE_PASS,
                        COMPATIBLE_MODE,
                        FILE_FIELDS_DELIMITER,
                        FILE_TEMP_PATH)
                .build();
    }
}
