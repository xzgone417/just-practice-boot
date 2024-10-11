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
package com.egrid.generator.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.egrid.core.base.model.BaseModel;

public class ProjectConfig extends BaseModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6905915447368712061L;
	
	private String buildPath;//文件创建的根路径（src的父目录）
	private String groupId;
	private String parentArtifactId;
    private String parentVersion;
	private String artifactId;
	private String version;
	
	private String port;
	
	private List<Map<String, Object>> dependencies = new ArrayList<>();
	
	public String getBuildPath() {
		return buildPath;
	}
	public void setBuildPath(String buildPath) {
		this.buildPath = buildPath;
	}
    public String getGroupId() {
        return groupId;
    }
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    public String getParentArtifactId() {
        return parentArtifactId;
    }
    public void setParentArtifactId(String parentArtifactId) {
        this.parentArtifactId = parentArtifactId;
    }
    public String getArtifactId() {
        return artifactId;
    }
    public void setArtifactId(String artifactId) {
        this.artifactId = artifactId;
    }
    public String getVersion() {
        return version;
    }
    public void setVersion(String version) {
        this.version = version;
    }
    public List<Map<String, Object>> getDependencies() {
        return dependencies;
    }
    public String getParentVersion() {
        return parentVersion;
    }
    public void setParentVersion(String parentVersion) {
        this.parentVersion = parentVersion;
    }
    public String getPort() {
        return port;
    }
    public void setPort(String port) {
        this.port = port;
    }
}
