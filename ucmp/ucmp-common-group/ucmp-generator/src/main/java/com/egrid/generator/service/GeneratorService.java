/**
 * Copyright 2017 伊永飞
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
 */
package com.egrid.generator.service;

import java.sql.Connection;
import java.util.Set;

import com.egrid.generator.dto.GeneratorConfig;

/**
 * 
 * @author yiyongfei
 *
 */
public interface GeneratorService {
	
	
	public Set<String> generate(Connection conn, GeneratorConfig config) throws Exception;
}
