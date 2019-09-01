/*
 * Copyright 2016 LINE Corporation
 *
 * LINE Corporation licenses this file to you under the Apache License,
 * version 2.0 (the "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at:
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */

package com.github.pruknil.ctebot.spring;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;

public class CTEFuncImpl implements CTEFunc {
    @Autowired
    private ResourceLoader resourceLoader;

    public String reply(String msg) {
        if ("#tdp".equalsIgnoreCase(msg)) {
            return tdp();
        }
        if ("#batchple".equalsIgnoreCase(msg)) {
            return batchple();
        }
        if (msg.startsWith("#cost")) {
            return cost();
        }
        if ("#lab".equalsIgnoreCase(msg)) {
            return lab();
        }

        return null;
    }

    private String lab() {
        return readFile("lab");
    }

    private String cost() {
        return "cost()";
    }

    private String batchple() {
        return "batchple()";
    }

    private String tdp() {
        return readFile("tdp");
    }

    private String readFile(String filename) {
        Resource resource = resourceLoader.getResource("classpath:" + filename + ".txt");
        try {
            File f = resource.getFile();
            Path path = Paths.get(f.toURI());
            byte[] fileBytes = Files.readAllBytes(path);
            return new String(fileBytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
