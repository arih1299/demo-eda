/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package com.solace.samples.spring.scs;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CampaignDataProcessor {

	private static final Logger log = LoggerFactory.getLogger(CampaignDataProcessor.class);

	public static void main(String[] args) {
		SpringApplication.run(CampaignDataProcessor.class, args);
	}

	@Bean
	public Function<String, String> CampaignData() {
		return req -> {
			log.info("Received: " + req);

            // dummy processing - do nothing
            try {
                Thread.sleep(1000);
            }
            catch(Exception e) {
                e.printStackTrace();
            }

			log.info("Sending: " + req);

			return req;
		};
	}
}