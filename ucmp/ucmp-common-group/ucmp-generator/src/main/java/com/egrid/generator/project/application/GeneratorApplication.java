package com.egrid.generator.project.application;

import java.io.File;
import java.util.Map;

import com.egrid.core.util.StringUtil;
import com.egrid.generator.act.AbstractGenerator;
import com.egrid.generator.dto.ProjectConfig;
import com.google.common.base.Charsets;
import com.google.common.collect.Maps;
import com.google.common.io.Resources;
import com.hubspot.jinjava.Jinjava;

public class GeneratorApplication extends AbstractGenerator{

    public void generate(ProjectConfig config) throws Exception {
        File file = createFile(new File(config.getBuildPath()) + "/" + config.getArtifactId() + "/src/main/resources/application.yml");
        
        Jinjava jinjava = new Jinjava();
        Map<String, Object> context = Maps.newHashMap();
        context.put("project_group_id", config.getGroupId());
        context.put("project_artifact_id", config.getArtifactId());
        context.put("server_port", config.getPort());
        

        String template = Resources.toString(Resources.getResource("generationj2s/src/main/resources/application.yml.j2"), Charsets.UTF_8);
        String fileContent = jinjava.render(template, context);
        System.out.println(fileContent);

//        writeFile(fileContent, file);
    }
    
}
