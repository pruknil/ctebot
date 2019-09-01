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

public class CTEFuncImpl implements CTEFunc {

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

        return "";
    }

    private String lab() {
        return "lab()";
    }

    private String cost() {
        return "cost()";
    }

    private String batchple() {
        return "batchple()";
    }

    private String tdp() {
        return "doTDP()";
    }
}
