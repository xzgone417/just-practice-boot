package com.egrid.generator.project.pom;

import java.io.File;
import java.util.Map;

import com.egrid.core.util.StringUtil;
import com.egrid.generator.act.AbstractGenerator;
import com.egrid.generator.dto.ProjectConfig;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

public class GeneratorPom extends AbstractGenerator{

    public void generateParent(ProjectConfig config) throws Exception {
        File file = createFile(new File(config.getBuildPath()) + "/" + config.getArtifactId() + "/pom.xml");
        
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("project_group_id", config.getGroupId());
        context.put("project_artifact_id", config.getArtifactId());
        context.put("project_version", config.getVersion());
        context.put("project_dependencies", config.getDependencies());
        

        String template = Resources.toString(Resources.getResource("generationj2s/parentPom.xml.j2"), Charsets.UTF_8);
        String fileContent = jinjava.render(template, context);
        System.out.println(fileContent);

        writeFile(fileContent, file);
    }
    
    public void generate(ProjectConfig config) throws Exception {
        if (StringUtil.isEmpty(config.getVersion())) {
            config.setVersion(config.getParentVersion());
        }
        
        File file = createFile(new File(config.getBuildPath()) + "/" + config.getArtifactId() + "/pom.xml");
        
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("project_group_id", config.getGroupId());
        context.put("project_parent_artifact_id", config.getParentArtifactId());
        context.put("project_parent_version", config.getParentVersion());
        context.put("project_artifact_id", config.getArtifactId());
        context.put("project_version", config.getVersion());
        context.put("project_dependencies", config.getDependencies());
        

        String template = Resources.toString(Resources.getResource("generationj2s/pom.xml.j2"), Charsets.UTF_8);
        String fileContent = jinjava.render(template, context);
        System.out.println(fileContent);

//        writeFile(fileContent, file);
    }
}
