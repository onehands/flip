/*
 * Copyright 2012 Tacit Knowledge.
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
package com.tacitknowledge.flip.spring.config;

import com.tacitknowledge.flip.FeatureService;
import com.tacitknowledge.flip.FeatureServiceDirectFactory;
import com.tacitknowledge.flip.spring.FlipSpringAspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 *
 * @author ssoloviov
 */
@Configuration
@ImportResource("classpath:com/tacitknowledge/flip/spring/context.xml")
public class AnnotatedFlipSpringConfig {
    
    @Autowired
    private FeatureServiceDirectFactory factory;

    public static FlipSpringAspect createFlipSpringAspect(FeatureService featureService, String defaultUrl) {
        FlipSpringAspect aspect = new FlipSpringAspect();
        aspect.setFeatureService(featureService);
        aspect.setDefaultFlipDisabledUrl(defaultUrl);
        return aspect;
    }

    public static FlipSpringAspect createFlipSpringAspect(String defaultUrl) {
        FlipSpringAspect aspect = new FlipSpringAspect();
        aspect.setDefaultFlipDisabledUrl(defaultUrl);
        return aspect;
    }
    
    @Bean(name="featureService")
    public FeatureService featureService() {
        return factory.createFeatureService();
    }
    
}